# MariaDB Replication setup

Topology

```
+-----------------------------+          +-----------------------------+
|        152.77.78.25         |          |         152.77.78.24        |
|       mariadb master        |          |         mariadb slave       |
|                             +<---------+                             |
+-----------------------------+          +-----------------------------+

```

## Replication setup

### Master setup

Ensure server is listening on 0.0.0.0:3306 and not only on localhost.
Create a replication user for the slave :

```
GRANT REPLICATION SLAVE ON *.* TO replication_user;
SET PASSWORD FOR replication_user = PASSWORD('newpass');
```

Edit `/etc/mysql/mariadb.conf.d/50-server.cnf` and add following lines to proper section

```
server_id = 1 # Must be unique for each node of the replication group
log_bin = /var/log/mysql/mysql-bin.log
log-basename = master1
```

Restart mysql server

Then connect to mysql prompt on master and run `FLUSH TABLES WITH READ LOCK`
Then retrieve current binlog name and position using :

```
SHOW MASTER STATUS;
+--------------------+----------+--------------+------------------+
| File               | Position | Binlog_Do_DB | Binlog_Ignore_DB |
+--------------------+----------+--------------+------------------+
| master1-bin.000001 |      568 |              |                  |
+--------------------+----------+--------------+------------------+
```

Don't close the prompt (will release the lock) and copy data from master to slave.
The fast dirty way (copi whole /var/lib/mysql directory) :

```
# On slave
systemctl stop mysql
rsync -arvz im2ag@152.77.78.24:/var/lib/mysql /var/lib/mysql
chown -R mysql:mysql /var/lib/mysql
systemctl start mysql
```

Then unlock tables on master `UNLOCK TABLES;`

### Slave setup

Edit `/etc/mysql/mariadb.conf.d/50-server.cnf` and add following lines to proper section

```
server_id = 2 # Must be different from master value
log_bin = /var/log/mysql/mysql-bin.log
log-basename = master1
```

Open a mysql prompt on the slave

```
# Replace MASTER_LOG_FILE and MASTER_LOG_POS values by the earlier show master status command results. 
change master to MASTER_HOST='152.77.78.25', MASTER_USER='replication_user', MASTER_PASSWORD='newpass', MASTER_PORT=3306, MASTER_LOG_FILE='master1-bin.000001', MASTER_LOG_POS=568, MASTER_CONNECT_RETRY=10;
# Start replication slave
START SLAVE;
```

### Test setup

On slave to check if replication is running use :

```
MariaDB [(none)]> show slave status\G
*************************** 1. row ***************************
               Slave_IO_State: Waiting for master to send event
                  Master_Host: 152.77.78.25
                  Master_User: replication_user
                  Master_Port: 3306
                Connect_Retry: 10
              Master_Log_File: master1-bin.000002
          Read_Master_Log_Pos: 1400
               Relay_Log_File: mysqld-relay-bin.000003
                Relay_Log_Pos: 1689
        Relay_Master_Log_File: master1-bin.000002
             Slave_IO_Running: Yes
            Slave_SQL_Running: Yes
              Replicate_Do_DB:
          Replicate_Ignore_DB:
           Replicate_Do_Table:
       Replicate_Ignore_Table:
      Replicate_Wild_Do_Table:
  Replicate_Wild_Ignore_Table:
                   Last_Errno: 0
                   Last_Error:
                 Skip_Counter: 0
          Exec_Master_Log_Pos: 1400
              Relay_Log_Space: 2276
              Until_Condition: None
               Until_Log_File:
                Until_Log_Pos: 0
           Master_SSL_Allowed: No
           Master_SSL_CA_File:
           Master_SSL_CA_Path:
              Master_SSL_Cert:
            Master_SSL_Cipher:
               Master_SSL_Key:
        Seconds_Behind_Master: 0
Master_SSL_Verify_Server_Cert: No
                Last_IO_Errno: 0
                Last_IO_Error:
               Last_SQL_Errno: 0
               Last_SQL_Error:
  Replicate_Ignore_Server_Ids:
             Master_Server_Id: 1
               Master_SSL_Crl:
           Master_SSL_Crlpath:
                   Using_Gtid: No
                  Gtid_IO_Pos:
1 row in set (0.00 sec)
```

Check theses values :

```
# Should be Yes
Slave_IO_Running: Yes
# Should be Yes
Slave_SQL_Running: Yes
# Should be 0
Seconds_Behind_Master: 0
# Should match master values (could change if transactions are currenlty running on cluster)
Master_Log_File: master1-bin.000002
Read_Master_Log_Pos: 1400
```



