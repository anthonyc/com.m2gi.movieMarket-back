-- Généré le :  Ven 10 Novembre 2017 à 13:01

--
-- Base de données :  `movieMarket`
--

-- --------------------------------------------------------

--
-- Charset Utf8
--

charset utf8;

--
-- Contenu de la table `movie`
--

INSERT INTO `movie` (`id`, `name`, `img`, `description`, `price`, `quantity`, `releaseYear`) VALUES
(1, "Wonder Woman", "wonder-woman.jpg", "C'était avant qu'elle ne devienne Wonder Woman, à l'époque où elle était encore Diana, princesse des Amazones et combattante invincible. Un jour, un pilote américain s'écrase sur l'île paradisiaque où elle vit, à l'abri des fracas du monde. Lorsqu'il lui raconte qu'une guerre terrible fait rage à l'autre bout de la planète, Diana quitte son havre de paix, convaincue qu'elle doit enrayer la menace. En s'alliant aux hommes dans un combat destiné à mettre fin à la guerre, Diana découvrira toute l'étendue de ses pouvoirs… et son véritable destin.", 14.99, 50, "2017-01-01 00:00:00"),
(2, "La planète des singes", "La-Planete-des-Singes.jpg", "Dans ce volet final de la trilogie, César, à la tête des Singes, doit défendre les siens contre une armée humaine prônant leur destruction. L’issue du combat déterminera non seulement le destin de chaque espèce, mais aussi l’avenir de la planète.", 14.99, 50, "2017-01-01 00:00:00"),
(3, "Oblivion", "oblivion.jpg", "Après des décennies de guerre contre la terrible menace dénommée les Scavs, les humains ont quittés la Terre. Jack Harper, qui vit sur une station située dans les nuages, a pour mission d'extraire des ressources vitales nécessaires aux humains expatriés. Son existence est bouleversée lorsqu'il sauve une belle inconnue d'un vaisseau en déperdition. Son arrivée va déclencher une série d'évènements qui vont le forcer à remettre en question tout ce qu'il connaissait.", 14.99, 50, "2013-01-01 00:00:00"),
(4, "Star Wars - Episode 4 : Un Nouvel Espoir", "star-wars-4.jpg", "Il y a bien longtemps, dans une galaxie très lointaine... La guerre civile fait rage entre l'Empire galactique et l'Alliance rebelle. Capturée par les troupes de choc de l'Empereur menées par le sombre et impitoyable Dark Vador, la princesse Leia Organa dissimule les plans de l'Etoile Noire, une station spatiale invulnérable, à son droïde R2-D2 avec pour mission de les remettre au Jedi Obi-Wan Kenobi. Accompagné de son fidèle compagnon, le droïde de protocole C-3PO, R2-D2 s'échoue sur la planète Tatooine et termine sa quête chez le jeune Luke Skywalker. Rêvant de devenir pilote mais confiné aux travaux de la ferme, ce dernier se lance à la recherche de ce mystérieux Obi-Wan Kenobi, devenu ermite au coeur des montagnes désertiques de Tatooine...", 14.99, 0, "1977-01-01 00:00:00"),
(5, "Star Wars - Episode 5 : L'Empire contre-attaque", "star-wars-5.jpg", "Malgré la destruction de l'Etoile Noire, l'Empire maintient son emprise sur la galaxie, et poursuit sans relâche sa lutte contre l'Alliance rebelle. Basés sur la planète glacée de Hoth, les rebelles essuient un assaut des troupes impériales. Parvenus à s'échapper, la princesse Leia, Han Solo, Chewbacca et C-3P0 se dirigent vers Bespin, la cité des nuages gouvernée par Lando Calrissian, ancien compagnon de Han. Suivant les instructions d'Obi-Wan Kenobi, Luke Skywalker se rend quant à lui vers le système de Dagobah, planète marécageuse où il doit recevoir l'enseignement du dernier maître Jedi, Yoda. Apprenant l'arrestation de ses compagnons par les stormtroopers de Dark Vador après la trahison de Lando, Luke décide d'interrompre son entraînement pour porter secours à ses amis et affronter le sombre seigneur Sith...", 14.99, 0, "1980-01-01 00:00:00"),
(6, "Star Wars - Episode 6 : Le retour du Jedi", "star-wars-6.jpg", "L'Empire galactique est plus puissant que jamais : la construction de la nouvelle arme, l'Etoile de la Mort, menace l'univers tout entier... Arrêté après la trahison de Lando Calrissian, Han Solo est remis à l'ignoble contrebandier Jabba Le Hutt par le chasseur de primes Boba Fett. Après l'échec d'une première tentative d'évasion menée par la princesse Leia, également arrêtée par Jabba, Luke Skywalker et Lando parviennent à libérer leurs amis.
Han, Leia, Chewbacca, C-3PO et Luke, devenu un Jedi, s'envolent dès lors pour une mission d'extrême importance sur la lune forestière d'Endor, afin de détruire le générateur du bouclier de l'Etoile de la Mort et permettre une attaque des pilotes de l'Alliance rebelle. Conscient d'être un danger pour ses compagnons, Luke préfère se rendre aux mains de Dark Vador, son père et ancien Jedi passé du côté obscur de la Force.", 14.99, 0, "1983-01-01 00:00:00"),
(7, "Star Wars - Episode 1 : La menace fantôme", "star-wars-1.jpg", "Avant de devenir un célèbre chevalier Jedi, et bien avant de se révéler l’âme la plus noire de la galaxie, Anakin Skywalker est un jeune esclave sur la planète Tatooine. La Force est déjà puissante en lui et il est un remarquable pilote de Podracer. Le maître Jedi Qui-Gon Jinn le découvre et entrevoit alors son immense potentiel. 
Pendant ce temps, l’armée de droïdes de l’insatiable Fédération du Commerce a envahi Naboo, une planète pacifique, dans le cadre d’un plan secret des Sith visant à accroître leur pouvoir. Pour défendre la reine de Naboo, Amidala, les chevaliers Jedi vont devoir affronter le redoutable Seigneur Sith, Dark Maul.", 14.99, 50, "1999-01-01 00:00:00"),
(8, "Star Wars - Episode 2 : L'attaque des clones", "star-wars-2.jpg", "Depuis le blocus de la planète Naboo par la Fédération du commerce, la République, gouvernée par le Chancelier Palpatine, connaît une véritable crise. Un groupe de dissidents, mené par le sombre Jedi comte Dooku, manifeste son mécontentement envers le fonctionnement du régime. Le Sénat et la population intergalactique se montrent pour leur part inquiets face à l'émergence d'une telle menace.
Certains sénateurs demandent à ce que la République soit dotée d'une solide armée pour empêcher que la situation ne se détériore davantage. Parallèlement, Padmé Amidala, devenue sénatrice, est menacée par les séparatistes et échappe de justesse à un attentat. Le Padawan Anakin Skywalker est chargé de sa protection. Son maître, Obi-Wan Kenobi, part enquêter sur cette tentative de meurtre et découvre la constitution d'une mystérieuse armée de clones...", 14.99, 50, "2002-01-01 00:00:00"),
(9, "Star Wars - Episode 3 - La revanche des Sith", "star-wars-3.jpg", "La Guerre des Clones fait rage. Une franche hostilité oppose désormais le Chancelier Palpatine au Conseil Jedi. Anakin Skywalker, jeune Chevalier Jedi pris entre deux feux, hésite sur la conduite à tenir. Séduit par la promesse d'un pouvoir sans précédent, tenté par le côté obscur de la Force, il prête allégeance au maléfique Darth Sidious et devient Dark Vador.
Les Seigneurs Sith s'unissent alors pour préparer leur revanche, qui commence par l'extermination des Jedi. Seuls rescapés du massacre, Yoda et Obi Wan se lancent à la poursuite des Sith. La traque se conclut par un spectaculaire combat au sabre entre Anakin et Obi Wan, qui décidera du sort de la galaxie.", 14.99, 50, "2005-01-01 00:00:00"),
(10, "Star Wars - Episode 7 : Le réveil de la force", "star-wars-7.jpg", "Dans une galaxie lointaine, très lointaine, un nouvel épisode de la saga \"Star Wars\", 30 ans après les événements du \"Retour du Jedi\".", 14.99, 50, "2015-01-01 00:00:00"),
(11, "Rogue One - A Star Wars Story", "star-wars-rogue-one.jpg", "Situé entre les épisodes III et IV de la saga Star Wars, le film nous entraîne aux côtés d’individus ordinaires qui, pour rester fidèles à leurs valeurs, vont tenter l’impossible au péril de leur vie. Ils n’avaient pas prévu de devenir des héros, mais dans une époque de plus en plus sombre, ils vont devoir dérober les plans de l’Étoile de la Mort, l’arme de destruction ultime de l’Empire.", 14.99, 50, "2016-01-01 00:00:00"),
(12, "Matrix", "matrix-1.jpg", "Programmeur anonyme dans un service administratif le jour, Thomas Anderson devient Neo la nuit venue. Sous ce pseudonyme, il est l'un des pirates les plus recherchés du cyber-espace. A cheval entre deux mondes, Neo est assailli par d'étranges songes et des messages cryptés provenant d'un certain Morpheus. Celui-ci l'exhorte à aller au-delà des apparences et à trouver la réponse à la question qui hante constamment ses pensées : qu'est-ce que la Matrice ? Nul ne le sait, et aucun homme n'est encore parvenu à en percer les defenses. Mais Morpheus est persuadé que Neo est l'Elu, le libérateur mythique de l'humanité annoncé selon la prophétie. Ensemble, ils se lancent dans une lutte sans retour contre la Matrice et ses terribles agents...", 14.99, 50, "1999-01-01 00:00:00"),
(13, "Matrix - Reloaded", "matrix-2.jpg", "Neo apprend à mieux contrôler ses dons naturels, alors même que Sion s'apprête à tomber sous l'assaut de l'Armée des Machines. D'ici quelques heures, 250 000 Sentinelles programmées pour anéantir notre espèce envahiront la dernière enclave humaine de la Terre.
Mais Morpheus galvanise les citoyens de Sion en leur rappelant la Parole de l'Oracle : il est encore temps pour l'Elu d'arrêter la guerre contre les Machines. Tous les espoirs se reportent dès lors sur Neo. Au long de sa périlleuse plongée au sein de la Matrix et de sa propre destinée, ce dernier sera confronté à une résistance croissante, une vérité encore plus aveuglante, un choix encore plus douloureux que tout ce qu'il avait jamais imaginé.", 14.99, 50, "2003-01-01 00:00:00"),
(14, "Matrix - Revolutions", "matrix-3.jpg", "La longue quête de liberté des rebelles culmine en une bataille finale explosive. Tandis que l'armée des Machines sème la désolation sur Zion, ses citoyens organisent une défense acharnée. Mais pourront-ils retenir les nuées implacables des Sentinelles en attendant que Neo s'approprie l'ensemble de ses pouvoirs et mette fin à la guerre ?
L'agent Smith est quant à lui parvenu à prendre possession de l'esprit de Bane, l'un des membres de l'équipage de l'aéroglisseur. De plus en plus puissant, il est désormais incontrôlable et n'obéit plus aux Machines : il menace de détruire leur empire ainsi que le monde réel et la Matrice...", 14.99, 50, "2003-01-01 00:00:00"),
(15, "Le  Seigneur des Anneaux - La communauté de l'anneau", "LotR-1.jpg", "Dans ce chapitre de la trilogie, le jeune et timide Hobbit, Frodon Sacquet, hérite d'un anneau. Bien loin d'être une simple babiole, il s'agit de l'Anneau Unique, un instrument de pouvoir absolu qui permettrait à Sauron, le Seigneur des ténèbres, de régner sur la Terre du Milieu et de réduire en esclavage ses peuples. À moins que Frodon, aidé d'une Compagnie constituée de Hobbits, d'Hommes, d'un Magicien, d'un Nain, et d'un Elfe, ne parvienne à emporter l'Anneau à travers la Terre du Milieu jusqu'à la Crevasse du Destin, lieu où il a été forgé, et à le détruire pour toujours. Un tel périple signifie s'aventurer très loin en Mordor, les terres du Seigneur des ténèbres, où est rassemblée son armée d'Orques maléfiques... La Compagnie doit non seulement combattre les forces extérieures du mal mais aussi les dissensions internes et l'influence corruptrice qu'exerce l'Anneau lui-même.
L'issue de l'histoire à venir est intimement liée au sort de la Compagnie.", 14.99, 50, "2001-01-01 00:00:00"),
(16, "Le Seigneur des Anneaux - Les Deux Tours", "LotR-2.jpg", "Après la mort de Boromir et la disparition de Gandalf, la Communauté s'est scindée en trois. Perdus dans les collines d'Emyn Muil, Frodon et Sam découvrent qu'ils sont suivis par Gollum, une créature versatile corrompue par l'Anneau. Celui-ci promet de conduire les Hobbits jusqu'à la Porte Noire du Mordor. A travers la Terre du Milieu, Aragorn, Legolas et Gimli font route vers le Rohan, le royaume assiégé de Theoden. Cet ancien grand roi, manipulé par l'espion de Saroumane, le sinistre Langue de Serpent, est désormais tombé sous la coupe du malfaisant Magicien. Eowyn, la nièce du Roi, reconnaît en Aragorn un meneur d'hommes. Entretemps, les Hobbits Merry et Pippin, prisonniers des Uruk-hai, se sont échappés et ont découvert dans la mystérieuse Forêt de Fangorn un allié inattendu : Sylvebarbe, gardien des arbres, représentant d'un ancien peuple végétal dont Saroumane a décimé la forêt...", 14.99, 50, "2002-01-01 00:00:00"),
(17, "Le Seigneur des Anneaux - Le Retour du Roi", "LotR-3.jpg", "Les armées de Sauron ont attaqué Minas Tirith, la capitale de Gondor. Jamais ce royaume autrefois puissant n'a eu autant besoin de son roi. Mais Aragorn trouvera-t-il en lui la volonté d'accomplir sa destinée ?
Tandis que Gandalf s'efforce de soutenir les forces brisées de Gondor, Théoden exhorte les guerriers de Rohan à se joindre au combat. Mais malgré leur courage et leur loyauté, les forces des Hommes ne sont pas de taille à lutter contre les innombrables légions d'ennemis qui s'abattent sur le royaume...
Chaque victoire se paye d'immenses sacrifices. Malgré ses pertes, la Communauté se jette dans la bataille pour la vie, ses membres faisant tout pour détourner l'attention de Sauron afin de donner à Frodon une chance d'accomplir sa quête.
Voyageant à travers les terres ennemies, ce dernier doit se reposer sur Sam et Gollum, tandis que l'Anneau continue de le tenter...", 14.99, 50, "2003-01-01 00:00:00"),
(18, "Le Hobbit - Un Voyage Innatendu", "hobbit-1.jpg", "Dans UN VOYAGE INATTENDU, Bilbon Sacquet cherche à reprendre le Royaume perdu des Nains d'Erebor, conquis par le redoutable dragon Smaug. Alors qu'il croise par hasard la route du magicien Gandalf le Gris, Bilbon rejoint une bande de 13 nains dont le chef n'est autre que le légendaire guerrier Thorin Écu-de-Chêne. Leur périple les conduit au cœur du Pays Sauvage, où ils devront affronter des Gobelins, des Orques, des Ouargues meurtriers, des Araignées géantes, des Métamorphes et des Sorciers…
Bien qu'ils se destinent à mettre le cap sur l'Est et les terres désertiques du Mont Solitaire, ils doivent d'abord échapper aux tunnels des Gobelins, où Bilbon rencontre la créature qui changera à jamais le cours de sa vie : Gollum.
C'est là qu'avec Gollum, sur les rives d'un lac souterrain, le modeste Bilbon Sacquet non seulement se surprend à faire preuve d'un courage et d'une intelligence inattendus, mais parvient à mettre la main sur le \"précieux\" anneau de Gollum qui recèle des pouvoirs cachés… Ce simple anneau d'or est lié au sort de la Terre du Milieu, sans que Bilbon s'en doute encore…", 14.99, 50, "2012-01-01 00:00:00"),
(19, "Le Hobbit - La Désolation de Smaug", "hobbit-2.jpg", "Atteignant enfin la Montagne Solitaire, Thorin et les Nains, aidés par Bilbon le Hobbit, ont réussi à récupérer leur royaume et leur trésor. Mais ils ont également réveillé le dragon Smaug qui déchaîne désormais sa colère sur les habitants de Lac-ville. A présent, les Nains, les Elfes, les Humains mais aussi les Wrags et les Orques menés par le Nécromancien, convoitent les richesses de la Montagne Solitaire. La bataille des cinq armées est imminente et Bilbon est le seul à pouvoir unir ses amis contre les puissances obscures de Sauron.", 14.99, 50, "2013-01-01 00:00:00"),
(20, "Le Hobbit - La Bataille des Cinq Armées", "hobbit-3.jpg", "Atteignant enfin la Montagne Solitaire, Thorin et les Nains, aidés par Bilbon le Hobbit, ont réussi à récupérer leur royaume et leur trésor. Mais ils ont également réveillé le dragon Smaug qui déchaîne désormais sa colère sur les habitants de Lac-ville. A présent, les Nains, les Elfes, les Humains mais aussi les Wrags et les Orques menés par le Nécromancien, convoitent les richesses de la Montagne Solitaire. La bataille des cinq armées est imminente et Bilbon est le seul à pouvoir unir ses amis contre les puissances obscures de Sauron.", 14.99, 50, "2014-01-01 00:00:00"),
(21, "Harry Potter à l'Ecole des Sorciers", "harry-potter-1.jpg", "Harry Potter, un jeune orphelin, est élevé par son oncle Vernon et sa tante Pétunia qui le détestent. Alors qu'il était haut comme trois pommes, ces derniers lui ont raconté que ses parents étaient morts dans un accident de voiture.
Le jour de son onzième anniversaire, Harry reçoit la visite inattendue d'un homme gigantesque se nommant Rubeus Hagrid. Celui-ci lui révèle qu'il est en fait le fils de deux puissants magiciens et qu'il possède lui aussi d'extraordinaires pouvoirs.
C'est avec joie que le garçon accepte de suivre des cours à Poudlard, la célèbre école de sorcellerie. Il a enfin la chance de se faire des amis. Blâmé par le professeur Severus Rogue qui lui enseigne les potions et protégé par Albus Dumbledore, le directeur de l'établissement, Harry va tenter d'élucider le mystère de la pierre philosophale.", 14.99, 50, "2001-01-01 00:00:00"),
(22, "Harry Potter et la Chambre des Secrets", "harry-potter-2.jpg", "Alors que l'oncle Vernon, la tante Pétunia et son cousin Dudley reçoivent d'importants invités à dîner, Harry Potter est contraint de passer la soirée dans sa chambre. Dobby, un elfe, fait alors son apparition. Il lui annonce que de terribles dangers menacent l'école de Poudlard et qu'il ne doit pas y retourner en septembre. Harry refuse de le croire.
Mais sitôt la rentrée des classes effectuée, ce dernier entend une voix malveillante. Celle-ci lui dit que la redoutable et légendaire Chambre des secrets est à nouveau ouverte, permettant ainsi à l'héritier de Serpentard de semer le chaos à Poudlard. Les victimes, retrouvées pétrifiées par une force mystérieuse, se succèdent dans les couloirs de l'école, sans que les professeurs - pas même le populaire Gilderoy Lockhart - ne parviennent à endiguer la menace. Aidé de Ron et Hermione, Harry doit agir au plus vite pour sauver Poudlard.", 14.99, 50, "2002-01-01 00:00:00"),
(23, "Harry Potter et le Prisonnier d'Azkaban ", "harry-potter-3.jpg", "Sirius Black, un dangereux sorcier criminel, s'échappe de la sombre prison d'Azkaban avec un seul et unique but : retrouver Harry Potter, en troisième année à l'école de Poudlard. Selon la légende, Black aurait jadis livré les parents du jeune sorcier à leur assassin, Lord Voldemort, et serait maintenant déterminé à tuer Harry...", 14.99, 50, "2004-01-01 00:00:00"),
(24, "Harry Potter et la Coupe de Feu", "harry-potter-4.jpg", "La quatrième année à l'école de Poudlard est marquée par le \"Tournoi des trois sorciers\". Les participants sont choisis par la fameuse \"coupe de feu\" qui est à l'origine d'un scandale. Elle sélectionne Harry Potter alors qu'il n'a pas l'âge légal requis !
Accusé de tricherie et mis à mal par une série d'épreuves physiques de plus en plus difficiles, ce dernier sera enfin confronté à Celui dont on ne doit pas prononcer le nom, Lord V.", 14.99, 50, "2005-01-01 00:00:00"),
(25, "Harry Potter et l'Ordre du Phoenix", "harry-potter-5.jpg", "Alors qu'il entame sa cinquième année d'études à Poudlard, Harry Potter découvre que la communauté des sorciers ne semble pas croire au retour de Voldemort, convaincue par une campagne de désinformation orchestrée par le Ministre de la Magie Cornelius Fudge. Afin de le maintenir sous surveillance, Fudge impose à Poudlard un nouveau professeur de Défense contre les Forces du Mal, Dolorès Ombrage, chargée de maintenir l'ordre à l'école et de surveiller les faits et gestes de Dumbledore. Prodiguant aux élèves des cours sans grand intérêt, celle qui se fait appeler la Grande Inquisitrice de Poudlard semble également décidée à tout faire pour rabaisser Harry. Entouré de ses amis Ron et Hermione, ce dernier met sur pied un groupe secret, L'Armée de Dumbledore, pour leur enseigner l'art de la défense contre les forces du Mal et se préparer à la guerre qui s'annonce...", 14.99, 50, "2007-01-01 00:00:00"),
(26, "Harry Potter et le Prince de Sang Mêlé", "harry-potter-6.jpg", "L'étau démoniaque de Voldemort se resserre sur l'univers des Moldus et le monde de la sorcellerie. Poudlard a cessé d'être un havre de paix, le danger rode au coeur du château... Mais Dumbledore est plus décidé que jamais à préparer Harry à son combat final, désormais imminent. Ensemble, le vieux maître et le jeune sorcier vont tenter de percer à jour les défenses de Voldemort. Pour les aider dans cette délicate entreprise, Dumbledore va relancer et manipuler son ancien collègue, le Professeur Horace Slughorn, qu'il croit en possession d'informations vitales sur le jeune Voldemort. Mais un autre \"mal\" hante cette année les étudiants : le démon de l'adolescence ! Harry est de plus en plus attiré par Ginny, qui ne laisse pas indifférent son rival, Dean Thomas ; Lavande Brown a jeté son dévolu sur Ron, mais oublié le pouvoir \"magique\" des chocolats de Romilda Vane ; Hermione, rongée par la jalousie, a décidé de cacher ses sentiments, vaille que vaille. L'amour est dans tous les coeurs - sauf un. Car un étudiant reste étrangement sourd à son appel. Dans l'ombre, il poursuit avec acharnement un but aussi mystérieux qu'inquiétant... jusqu'à l'inévitable tragédie qui bouleversera à jamais Poudlard...", 14.99, 50, "2009-01-01 00:00:00"),
(27, "Harry Potter et les Reliques de la Mort - Partie 1", "harry-potter-7-part1.jpg", "Le pouvoir de Voldemort s'étend. Celui-ci contrôle maintenant le Ministère de la Magie et Poudlard. Harry, Ron et Hermione décident de terminer le travail commencé par Dumbledore, et de retrouver les derniers Horcruxes pour vaincre le Seigneur des Ténèbres. Mais il reste bien peu d'espoir aux trois sorciers, qui doivent réussir à tout prix.", 14.99, 50, "2010-01-01 00:00:00"),
(28, "Harry Potter et les Reliques de la Mort - Partie 2", "harry-potter-7-part2.jpg", "Dans la 2e Partie de cet épisode final, le combat entre les puissances du bien et du mal de l’univers des sorciers se transforme en guerre sans merci. Les enjeux n’ont jamais été si considérables et personne n’est en sécurité. Mais c’est Harry Potter qui peut être appelé pour l’ultime sacrifice alors que se rapproche l’ultime épreuve de force avec Voldemort.", 14.99, 50, "2011-01-01 00:00:00"),
(29, "Pirates des Caraïbes - La malédiction du Black Pearl", "pirates-caraibes-1.jpg", "Dans la mer des Caraïbes, au XVIIe siècle, Jack Sparrow, flibustier gentleman, voit sa vie idylle basculer le jour où son ennemi, le perfide capitaine Barbossa, lui vole son bateau, le Black Pearl, puis attaque la ville de Port Royal, enlevant au passage la très belle fille du gouverneur, Elizabeth Swann. L'ami d'enfance de celle-ci, Will Turner, se joint à Jack pour se lancer aux trousses du capitaine.
Mais Will ignore qu'une malédiction frappe Barbossa et ses pirates. Lorsque la lune brille, ils se transforment en morts-vivants. Leur terrible sort ne prendra fin que le jour où le fabuleux trésor qu'ils ont amassé sera restitué...", 14.99, 50, "2003-01-01 00:00:00"),
(30, "Pirates des Caraïbes - Le Secret du Coffre Maudit", "pirates-caraibes-2.jpg", "Dans ce nouvel opus de l'aventure Pirates des Caraïbes, le toujours aussi excentrique pirate Jack Sparrow est confronté subitement à son passé. Treize ans auparavant, Jack signait un pacte avec Davey Jones, le maître des sept mers, dont l'esprit maléfique n'a d'égal que son apparence tentaculaire. En échange de son âme, ce dernier lui promettait le commandement du mythique Black Pearl...
Aujourd'hui, Jones vient donc récupérer sa dette. Mais donner son âme à Jones est sans issue, il n'y a pas de rédemption possible, c'est devenir comme tous les membres de son équipage maudit, un fantôme au physique aussi repoussant que terrifiant. Pour éviter ce sort funeste auquel Jack ne tient pas vraiment, il n'a qu'une solution : retrouver le coffre maudit de Jones où sont cachés les âmes emprisonnées...", 14.99, 50, "2006-01-01 00:00:00"),
(31, "Pirates des Caraïbes - Jusqu'au Bout du Monde ", "pirates-caraibes-3.jpg", "L'âge d'or de la piraterie touche à sa fin. Même le terrifiant Vaisseau Fantôme et son capitaine maudit Davy Jones servent à présent Lord Cutler Beckett et la Compagnie anglaise des Indes Orientales. L'invincible Hollandais Volant écume désormais les sept mers, massacrant sans pitié pirates de tous bords et sabordant leurs navires.
Will Turner, Elizabeth Swann et le capitaine Barbossa n'ont qu'une seule chance de résister à Beckett et à son armada destructrice : ils doivent rassembler les Neuf Seigneurs de la Cour des Frères, mais l'un des membres les plus éminents, le capitaine Jack Sparrow, manque à l'appel.
Will, Elizabeth et Barbossa, secondés par Tia Dalma, Pintel et Ragetti, doivent faire voile vers des mers orientales inconnues, pour affronter un pirate chinois, le capitaine Sao Feng, et s'emparer des cartes qui les conduiront au-delà des limites du monde connu, là où Jack est retenu...", 14.99, 50, "2007-01-01 00:00:00"),
(32, "Pirates des Caraïbes - La Fontaine de Jouvence", "pirates-caraibes-4.jpg", "Dans cette histoire pleine d’action, où vérité, trahison, jeunesse éternelle et mort forment un cocktail explosif, le capitaine Jack Sparrow retrouve une femme qu’il a connue autrefois. Leurs liens sont-ils faits d’amour ou cette femme n’est-elle qu’une aventurière sans scrupules qui cherche à l’utiliser pour découvrir la légendaire Fontaine de Jouvence ? Lorsqu’elle l’oblige à embarquer à bord du Queen Anne’s Revenge, le bateau du terrible pirate Barbe-Noire, Jack ne sait plus ce qu’il doit craindre le plus : le redoutable maître du bateau ou cette femme surgie de son passé...", 14.99, 50, "2011-01-01 00:00:00"),
(33, "Pirates des Caraïbes - La Vengeance de Salazar", "pirates-caraibes-5.jpg", "Les temps sont durs pour le Capitaine Jack, et le destin semble même vouloir s’acharner lorsqu’un redoutable équipage fantôme mené par son vieil ennemi, le terrifiant Capitaine Salazar, s’échappe du Triangle du Diable pour anéantir tous les flibustiers écumant les flots… Sparrow compris ! Le seul espoir de survie du Capitaine Jack est de retrouver le légendaire Trident de Poséidon, qui donne à celui qui le détient tout pouvoir sur les mers et les océans. Mais pour cela, il doit forger une alliance précaire avec Carina Smyth, une astronome aussi belle que brillante, et Henry, un jeune marin de la Royal Navy au caractère bien trempé. À la barre du Dying Gull, un minable petit rafiot, Sparrow va tout entreprendre pour contrer ses revers de fortune, mais aussi sauver sa vie face au plus implacable ennemi qu’il ait jamais eu à affronter…", 14.99, 50, "2017-01-01 00:00:00"),
(34, "Indiana Jones et les Aventuriers de l'Arche Perdue", "indiana-jones-1.jpg", "1936. Parti à la recherche d'une idole sacrée en pleine jungle péruvienne, l'aventurier Indiana Jones échappe de justesse à une embuscade tendue par son plus coriace adversaire : le Français René Belloq.
Revenu à la vie civile à son poste de professeur universitaire d'archéologie, il est mandaté par les services secrets et par son ami Marcus Brody, conservateur du National Museum de Washington, pour mettre la main sur le Médaillon de Râ, en possession de son ancienne amante Marion Ravenwood, désormais tenancière d'un bar au Tibet.
Cet artefact égyptien serait en effet un premier pas sur le chemin de l'Arche d'Alliance, celle-là même où Moïse conserva les Dix Commandements. Une pièce historique aux pouvoirs inimaginables dont Hitler cherche à s'emparer...", 14.99, 50, "1981-01-01 00:00:00"),
(35, "Indiana Jones et le Temple Maudit", "indiana-jones-2.jog", "L'archéologue aventurier Indiana Jones est de retour. Il poursuit une terrible secte qui a dérobé un joyau sacré doté de pouvoirs fabuleux. Une chanteuse de cabaret et un époustouflant gamin l'aideront a affronter les dangers les plus insensés.
", 14.99, 50, "1984-01-01 00:00:00"),
(36, "Indiana Jones et la Dernière Croisade", "indiana-jones-3.jpg", "L'archéologue aventurier Indiana Jones se retrouve aux prises avec un maléfique milliardaire. Aux côtés de la cupide Elsa et de son père, il part à la recherche du Graal.", 14.99, 50, "1989-01-01 00:00:00"),
(37, "Indiana Jones et le Crane de Crystal", "indiana-jones-4.jpg", "La nouvelle aventure d'Indiana Jones débute dans un désert du sud-ouest des Etats-Unis. Nous sommes en 1957, en pleine Guerre Froide. Indy et son copain Mac viennent tout juste d'échapper à une bande d'agents soviétiques à la recherche d'une mystérieuse relique surgie du fond des temps. De retour au Marshall College, le Professeur Jones apprend une très mauvaise nouvelle : ses récentes activités l'ont rendu suspect aux yeux du gouvernement américain. Le doyen Stanforth, qui est aussi un proche ami, se voit contraint de le licencier. A la sortie de la ville, Indiana fait la connaissance d'un jeune motard rebelle, Mutt, qui lui fait une proposition inattendue. En échange de son aide, il le mettra sur la piste du Crâne de Cristal d'Akator, relique mystérieuse qui suscite depuis des siècles autant de fascination que de craintes. Ce serait à coup sûr la plus belle trouvaille de l'histoire de l'archéologie. Indy et Mutt font route vers le Pérou, terre de mystères et de superstitions, où tant d'explorateurs ont trouvé la mort ou sombré dans la folie, à la recherche d'hypothétiques et insaisissables trésors. Mais ils réalisent très vite qu'ils ne sont pas seuls dans leur quête : les agents soviétiques sont eux aussi à la recherche du Crâne de Cristal, car il est dit que celui qui possède le Crâne et en déchiffre les énigmes s'assure du même coup le contrôle absolu de l'univers. Le chef de cette bande est la cruelle et somptueuse Irina Spalko. Indy n'aura jamais d'ennemie plus implacable... Indy et Mutt réuissiront-ils à semer leurs poursuivants, à déjouer les pièges de leurs faux amis et surtout à éviter que le Crâne de Cristal ne tombe entre les mains avides d'Irina et ses sinistres sbires ?
", 14.99, 50, "2008-01-01 00:00:00"),
(38, "Coexister", "Coexister.jpg", "Un producteur de musique à la dérive décide de monter un groupe constitué d'un rabbin, un curé et un imam afin de leur faire chanter le vivre-ensemble. Mais les religieux qu’il recrute sont loin d’être des saints…", 10.99, 40, "2017-01-01 00:00:00"),
(100,"La soupe aux choux","La-soupe-aux-choux.jpg","Le Claude et le Bombé, deux paysans du Bourbonnais portés sur la bouteille et la misanthropie, vivent dans un petit hameau, à la périphérie d'un village. Le premier est veuf, et le second célibataire. Une nuit, ils font la connaissance d'un extra-terrestre qui atterrit dans le champ du Claude dit le Glaude. L'extra-terrestre surnommé la Denrée découvre la soupe aux choux qui mijote chez le veuf et en apporte sur sa planète...
",8,50,"1981-01-01 00:00:00"),
(101,"L'avare","L'avare.jpg","En 1668, l'Avare nous conte les aventures d'Harpagon, riche veuf qui vit avec ses enfants Cléante et Elise. Il désire pour eux un mariage d'agent dont il serait pleinement bénéficiaire. De plus, il soupçonne tout le monde d'en avoir après son argent qu'il a enterré dans son jardin... 
",9,50,"1980-01-01 00:00:00"),
(102,"Le Gendarme et les extraterrestres","Le-gendarme-et-les-extraterrestes.jpg","Les membres de la brigade de St-Tropez tombent des nues lorsqu'ils rencontrent, les uns après les autres, leurs doubles sous forme d'extra-terrestre se disant pacifiques. La venue d'une soucoupe volante, la peur de l'inconnu et l'émotion qu'elle déclenche, va faire venir la presse du monde entier dans cette jolie petite ville du bord de mer. Mais comment reconnaître les vrais gendarmes des faux ? Comment reconnaître les humains de ces E.T. pas si gentils que ça et qui prennent l'apparence de tout un chacun ?
",5,50,"1979-01-01 00:00:00"),
(103,"T'as le bonjour de Trinita","T'as-le-bonjour-de-Trinita.jpg","Au coeur du Texas, un important convoi devient vite la cible de nombreux aventuriers, parmi lesquels Django, Ringo et Trinita qui ne reculent devant rien pour une poignée de dollars et n'hésitent pas à régler leurs comptes entre eux. Une femme bien singulière réussit par la ruse à substituer l'or avec la complicité des Indiens. Le butin ne restera cependant pas longtemps dans leurs mains. Trinita, en effet, qui a juré d'en faire sa possession, utilisera jusqu'à la séduction pour réaliser ses desseins. Pris, il lui faudra affronter jour et nuit la cruauté des hommes. Evadé, il déploiera toute la force et la violence qu'on lui connaît pour réduire ses ennemis à l'impuissance.
",5,50,"1967-01-01 00:00:00"),
(104,"On l'appelle Trinita","On-l'appelle-trinita.jpg","Trinita tireur émérite, retrouve par hasard son frère Bambino qui a usurpé l'identité du shérif local. Dans la vallée voisine, les menaces que subit une communauté de mormons de la part d'un terrible homme d'affaires et de ses hommes de main, va obliger les deux frères à venir faire le ménage...
",5,50,"1971-01-01 00:00:00"),
(105,"On continue à l'appeler Trinita","Trinita.jpg","Trinita et Bambino jurent à leur père mourant de respecter sa dernière volonté : devenir de vrais bandits et que leurs têtes respectives soient mises à prix généreusement. Mais la tâche va s'avérer plus difficile que prévue... 
",9,50,"1971-01-01 00:00:00"),
(106,"Et maintenant on l'appelle El Magnifico","Et-maintenant-on-l'appelle-El-Magnifico .jpg","Tom Moore est un étudiant assidu d’une grande école britannique. Lorsque son père, Joe, un célèbre cow-boy de l’Ouest américain, décède, Tom retourne dans sa ville natale où il rencontre les amis de son père : Bull, Holy Joe et Monkey, des hommes rustres sans aucune notion de politesse. Déçu d’imaginer son père côtoyer de telles personnes, Tom entreprend de les remettre sur le droit chemin. Mais les hommes du Far Ouest ne se laissent pas faire et décident à la place d’apprendre au jeune anglais à devenir un véritable cow-boy.
",8,50,"1972-01-01 00:00:00"),
(107,"Mon nom est Personne","Mon-nom-est-personne.jpg"," Jack Beauregard, légende de l'Ouest, désire mettre un terme à sa carrière de pistolero et envisage de s'embarquer pour l'Europe. Mais un jeune admirateur, affirmant s'appeler Personne, ne l'entend pas de cette oreille. Il veut faire entrer Beauregard dans l'Histoire en l'amenant à combattre la Horde sauvage.
",8,50,"1973-01-01 00:00:00"),
(108,"Cul et chemise","Culchemise.jpg","En Afrique, deux cousins blancs, Slim et Tom, passent leur temps à se jouer de mauvais tours. Mais, face à la menace d'un trafiquant d'ivoire, ils vont devoir faire équipe. En effet, le terrible Jack Hammer Ormond prévoit de détruire le village où habitent les autochtones ainsi que les deux compères. Tom, véritable force de la nature qui impressionne les hommes d'Ormond, se voit offrir de l'argent contre sa collaboration : c'est pour lui l'ocassion de jouer l'ultime farce à son cher cousin...
",7,50,"1979-01-01 00:00:00"),
(109,"Le Bon, la brute et le truand","Le-bon-la-brute-et-le-truand.jpg","Pendant la Guerre de Sécession, trois hommes, préférant s'intéresser à leur profit personnel, se lancent à la recherche d'un coffre contenant 200 000 dollars en pièces d'or volés à l'armée sudiste. Tuco sait que le trésor se trouve dans un cimetière, tandis que Joe connaît le nom inscrit sur la pierre tombale qui sert de cache. Chacun a besoin de l'autre. Mais un troisième homme entre dans la course : Setenza, une brute qui n'hésite pas à massacrer femmes et enfants pour parvenir à ses fins. 
",15,50,"1966-01-01 00:00:00"),
(110,"Lion","Lion.jpg","Une incroyable histoire vraie : à 5 ans, Saroo se retrouve seul dans un train traversant l'Inde qui l'emmène malgré lui à des milliers de kilomètres de sa famille. Perdu, le petit garçon doit apprendre à survivre seul dans l'immense ville de Calcutta. Après des mois d'errance, il est recueilli dans un orphelinat et adopté par un couple d'Australiens. 25 ans plus tard, Saroo est devenu un véritable Australien, mais il pense toujours à sa famille en Inde. Armé de quelques rares souvenirs et d'une inébranlable détermination, il commence à parcourir des photos satellites sur Google Earth, dans l'espoir de reconnaître son village. Mais peut-on imaginer retrouver une simple famille dans un pays d'un milliard d'habitants ?
",20,50,"2016-01-01 00:00:00"),
(111,"Baisers cachés","Baisers-caches.jpg","Nouveau venu au lycée, Nathan, 16 ans, vit seul avec son père policier, Stéphane. Leurs rapports sont complices. Nathan est invité à une soirée où il flashe sur un garçon de sa classe. Ils se retrouvent à l’abri des regards et s’embrassent.Mais quelqu’un les observe en cachette et publie la photo de leur baiser sur facebook : la rumeur se répand sur le net et provoque le scandale au lycée et dans les familles. Stéphane découvre l’homosexualité de son fils. Il est choqué et se détourne de Nathan. Au lycée, les élèves harcèlent Nathan et s’interrogent sur l’identité de l’autre garçon. Nathan, amoureux, refuse de révéler l’identité de son amoureux et fait front contre les moqueries et le violence. Pourra-t-il compter sur son père ? Et sur celui qu’il aime ?
", 12,50,"2016-01-01 00:00:00"),
(112,"Les Figures de l'ombre","Les-figures-de-l'ombre.jpg","Le destin extraordinaire des trois scientifiques afro-américaines qui ont permis aux États-Unis de prendre la tête de la conquête spatiale, grâce à la mise en orbite de l’astronaute John Glenn.Maintenues dans l’ombre de leurs collègues masculins et dans celle d’un pays en proie à de profondes inégalités, leur histoire longtemps restée méconnue est enfin portée à l’écran.
",15,50,"2016-01-01 00:00:00"),
(113,"Patients","Patients.jpg"," Se laver, s'habiller, marcher, jouer au basket, voici ce que Ben ne peut plus faire à son arrivée dans un centre de rééducation suite à un grave accident. Ses nouveaux amis sont tétras, paras, traumas crâniens.... Bref, toute la crème du handicap. Ensemble ils vont apprendre la patience. Ils vont résister, se vanner, s'engueuler, se séduire mais surtout trouver l'énergie pour réapprendre à vivre. Patients est l'histoire d'une renaissance, d'un voyage chaotique fait de victoires et de défaites, de larmes et d’éclats de rire, mais surtout de rencontres : on ne guérit pas seul. 
",15,50,"2017-01-01 00:00:00"),
(114,"I Am Not Your Negro","I-Am-Not-Your-Negro.jpg","À travers les propos et les écrits de l’écrivain noir américain James Baldwin, Raoul Peck propose un film qui revisite les luttes sociales et politiques des Afro-Américains au cours de ces dernières décennies.
",15,50,"2016-01-01 00:00:00"),
(115,"L'Accusé","L'accuse.jpg","Après s’être réveillé à côté du corps sans vie de sa petite amie à l’hôtel, un homme d’affaires engage une grande avocate pour comprendre ce qui s’est passé. 
",15,50,"2016-01-01 00:00:00"),
(116,"Logan","Logan.jpg","Dans un futur proche, un certain Logan, épuisé de fatigue, s’occupe d’un Professeur X souffrant, dans un lieu gardé secret à la frontière Mexicaine. Mais les tentatives de Logan pour se retrancher du monde et rompre avec son passé vont s’épuiser lorsqu’une jeune mutante traquée par de sombres individus va se retrouver soudainement face à lui.
",30,50,"2017-01-01 00:00:00"),
(117,"Les Oubliés","Les-oublies.jpg","1945. Danemark. Fin de la Seconde Guerre Mondiale. Plusieurs soldats allemands, à peine sortis de l’adolescence, sont faits prisonniers par l’armée danoise et envoyés en première ligne pour désamorcer les mines enfouies le long de la côte. Pour eux, la guerre est loin d’être terminée. Inspiré de faits réels, Les Oubliés raconte cet épisode tragique de l’Histoire.
",25,50,"2015-01-01 00:00:00"),
(118,"Les Gardiens de la Galaxie 2","Les-Gardiens-de-la-Galaxie-2.jpg","Musicalement accompagné de la 'Awesome Mixtape n°2' (la musique qu'écoute Star-Lord dans le film), Les Gardiens de la galaxie 2 poursuit les aventures de l'équipe alors qu'elle traverse les confins du cosmos. Les gardiens doivent combattre pour rester unis alors qu'ils découvrent les mystères de la filiation de Peter Quill. Les vieux ennemis vont devenir de nouveaux alliés et des personnages bien connus des fans de comics vont venir aider nos héros et continuer à étendre l'univers Marvel. 
",20,50,"2017-01-01 00:00:00"),
(119,"La Cigale, le corbeau et les poulets","La-Cigale-le-corbeau-et-les-poulets.jpg","Début 2009. Des balles de 9 mm et des lettres de menaces sont envoyées au président de la République, Nicolas Sarkozy. Pierrot, Tintin, le Suisse et leurs compères, dont le QG est un bureau de tabac nommé La Cigale à Saint-Pons-de-Thomières (Hérault), vont être accusés d’être le corbeau et poursuivis par tous les poulets antiterroristes de France. Mais pourquoi eux ? 
",10,50,"2016-01-01 00:00:00"),
(120,"Miss Sloane","Miss-Sloane.jpg","Elizabeth Sloane est une femme d’influence brillante et sans scrupules qui opère dans les coulisses de Washington. Face au plus grand défi de sa carrière, elle va redoubler de manigances et manipulations pour atteindre une victoire qui pourrait s’avérer éclatante. Mais les méthodes dont elle use pour parvenir à ses fins menacent à la fois sa carrière et ses proches. Miss Sloane pourrait bien avoir enfin trouvé un adversaire à sa taille. 
",15,50,"2016-01-01 00:00:00"),
(121,"Baby Driver","Baby-driver.jpg","Chauffeur pour des braqueurs de banque, Baby a un truc pour être le meilleur dans sa partie : il roule au rythme de sa propre playlist. Lorsqu’il rencontre la fille de ses rêves, Baby cherche à mettre fin à ses activités criminelles pour revenir dans le droit chemin. Mais il est forcé de travailler pour un grand patron du crime et le braquage tourne mal… Désormais, sa liberté, son avenir avec la fille qu’il aime et sa vie sont en jeu. 
", 17,50,"2017-01-01 00:00:00"),
(122,"Split","Split.jpg","Kevin a déjà révélé 23 personnalités, avec des attributs physiques différents pour chacune, à sa psychiatre dévouée, la docteure Fletcher, mais l’une d’elles reste enfouie au plus profond de lui. Elle va bientôt se manifester et prendre le pas sur toutes les autres. Poussé à kidnapper trois adolescentes, dont la jeune Casey, aussi déterminée que perspicace, Kevin devient dans son âme et sa chair, le foyer d’une guerre que se livrent ses multiples personnalités, alors que les divisions qui régnaient jusqu’alors dans son subconscient volent en éclats. 
",19,50,"2017-01-01 00:00:00"),
(123,"La Belle et la Bête","La-belle-et-la-bete-.jpg","Fin du XVIIIè siècle, dans un petit village français. Belle, jeune fille rêveuse et passionnée de littérature, vit avec son père, un vieil inventeur farfelu. S'étant perdu une nuit dans la fôret, ce dernier se réfugie au château de la Bête, qui le jette au cachot. Ne pouvant supporter de voir son père emprisonné, Belle accepte alors de prendre sa place, ignorant que sous le masque du monstre se cache un Prince Charmant tremblant d'amour pour elle, mais victime d'une terrible malédiction. 
",18,50,"2017-01-01 00:00:00"),
(124,"Get Out","Get-out.jpg","Couple mixte, Chris et sa petite amie Rose  filent le parfait amour. Le moment est donc venu de rencontrer la belle famille, Missy et Dean lors d’un week-end sur leur domaine dans le nord de l’État. Chris commence par penser que l’atmosphère tendue est liée à leur différence de couleur de peau, mais très vite une série d’incidents de plus en plus inquiétants lui permet de découvrir l’inimaginable. 
",14,50,"2017-01-01 00:00:00"),
(125,"Virtual Revolution","Virtual-revolution.jpg","A Paris, en 2047, alors que la population vit connectée en permanence à des mondes virtuels, un agent employé par une multinationale est chargé de traquer des terroristes qui menacent le système. 
",15,50,"2016-01-01 00:00:00"),
(126,"Fast and Furious 8","Fast-and-furious-8.jpg","Maintenant que Dom et Letty sont en lune de miel, que Brian et Mia se sont rangés et que le reste de l’équipe a été disculpé, la bande de globetrotteurs retrouve un semblant de vie normale. Mais quand une mystérieuse femme entraîne Dom dans le monde de la criminalité, ce dernier ne pourra éviter de trahir ses proches qui vont faire face à des épreuves qu’ils n’avaient jamais rencontrées jusqu’alors. Des rivages de Cuba au rues de New York en passant par les plaines gelées de la mer arctique de Barrents, notre équipe va sillonner le globe pour tenter d'empêcher une anarchiste de déchaîner un chaos mondial et de ramener à la maison l’homme qui a fait d’eux une famille. 
",25,50,"2016-01-01 00:00:00"),
(127,"Moonlight","Moonlight.jpg","Après avoir grandi dans un quartier difficile de Miami, Chiron, un jeune homme tente de trouver sa place dans le monde. Moonlight évoque son parcours, de l’enfance à l’âge adulte. 
",15,50,"2017-01-01 00:00:00"),
(128,"American Honey","American-hooney.jpg","Star, 17 ans, croise le chemin de Jake et sa bande. Sillonant le midwest à bord d’un van, ils vivent de vente en porte à porte. En rupture totale avec sa famille, elle s’embarque dans l’aventure. Ce roadtrip, ponctué de rencontres, fêtes et arnaques lui apporte ce qu’elle cherche depuis toujours: la liberté ! Jusqu’à ce qu’elle tombe amoureuse de Jake, aussi charismatique que dangereux…. 
",15,50,"2016-01-01 00:00:00"),
(129,"Alibi.com","Alibi-com.jpg","Greg a fondé une entreprise nommée Alibi.com qui crée tout type d'alibi. Avec Augustin son associé, et Medhi son nouvel employé, ils élaborent des stratagèmes et mises en scène imparables pour couvrir leurs clients. Mais la rencontre de Flo, une jolie blonde qui déteste les hommes qui mentent, va compliquer la vie de Greg, qui commence par lui cacher la vraie nature de son activité. Lors de la présentation aux parents, Greg comprend que Gérard, le père de Flo, est aussi un de leurs clients... 
",15,50,"2017-01-01 00:00:00"),
(130,"Le Caire Confidentiel","Le-caire-confidentiel.jpg","Le Caire, janvier 2011, quelques jours avant le début de la révolution. Une jeune chanteuse est assassinée dans une chambre d’un des grands hôtels de la ville. Noureddine, inspecteur revêche chargé de l’enquête, réalise au fil de ses investigations que les coupables pourraient bien être liés à la garde rapprochée du président Moubarak. 
",15,50,"2017-01-01 00:00:00"),
(131,"Corporate","Corporate.jpg","Emilie Tesson-Hansen est une jeune et brillante responsable des Ressources Humaines, une « killeuse ». Suite à un drame dans son entreprise, une enquête est ouverte. Elle se retrouve en première ligne. Elle doit faire face à la pression de l’inspectrice du travail, mais aussi à sa hiérarchie qui menace de se retourner contre elle. Emilie est bien décidée à sauver sa peau. Jusqu’où restera-t-elle corporate ? 
",15,50,"2016-01-01 00:00:00"),
(132,"John Wick 2","John-wick-2.jpg","John Wick est forcé de sortir de sa retraite volontaire par un de ses ex-associés qui cherche à prendre le contrôle d’une mystérieuse confrérie de tueurs internationaux. Parce qu’il est lié à cet homme par un serment, John se rend à Rome, où il va devoir affronter certains des tueurs les plus dangereux du monde. 
",15,50,"2017-01-01 00:00:00"),
(133,"Born to be blue","Born-to-be-blue.jpg"," Le jour où il est passé à tabac, la vie de Chet bascule. Les mâchoires fracassées, il se voit contraint de laisser derrière lui sa carrière de trompettiste de jazz. Avec à la clé, la dépression et l’appel irrépressible de la drogue. Mais Jane, sa compagne, ne l’entend pas de cette oreille : la seule addiction qui vaille, c’est la musique. Il doit se ressaisir et regagner par son talent la reconnaissance de ses pairs. L’Histoire n’oubliera pas son nom : il s’appelle Chet Baker.
",15,50,"2015-01-01 00:00:00"),
(134,"Le Fondateur","Le-fondateur.jpg","Dans les années 50, Ray Kroc rencontre les frères McDonald qui tiennent un restaurant de burgers en Californie. Bluffé par leur concept, Ray leur propose de franchiser la marque et va s'en emparer pour bâtir l'empire que l'on connaît aujourd'hui. 
",15,50,"2016-01-01 00:00:00"),
(135,"Cessez-le-feu","Cessez-le-feu.jpg","1923. Georges, héros de 14 fuyant son passé, mène depuis quatre ans une vie nomade et aventureuse en Afrique lorsqu'il décide de rentrer en France. Il y retrouve sa mère et son frère Marcel, invalide de guerre muré dans le silence. Peinant à retrouver une place dans cet Après-guerre où la vie a continué sans lui, il fait la rencontre d'Hélène, professeure de langue des signes avec qui il noue une relation tourmentée... 
",15,50,"2017-01-01 00:00:00"),
(136,"The Lost City of Z","The-lost-city-of-Z.jpg","L’histoire vraie de Percival Harrison Fawcett, un des plus grands explorateurs du XXe siècle. Percy Fawcett est un colonel britannique reconnu et un mari aimant. En 1906, alors qu’il s’apprête à devenir père, la Société géographique royale d'Angleterre lui propose de partir en Amazonie afin de cartographier les frontières entre le Brésil et la Bolivie. Sur place, l’homme se prend de passion pour l’exploration et découvre des traces de ce qu’il pense être une cité perdue très ancienne. De retour en Angleterre, Fawcett n’a de cesse de penser à cette mystérieuse civilisation, tiraillé entre son amour pour sa famille et sa soif d’exploration et de gloire… 
",15,50,"2016-01-01 00:00:00"),
(137,"HHhH","HHhH.jpg"," L’ascension fulgurante de Reinhard Heydrich, militaire déchu, entraîné vers l’idéologie nazie par sa femme Lina. Bras droit d’Himmler et chef de la Gestapo, Heydrich devient l’un des hommes les plus dangereux du régime. Hitler le nomme à Prague pour prendre le commandement de la Bohême-Moravie et lui confie le soin d’imaginer un plan d’extermination définitif. Il est l’architecte de la Solution Finale. Face à lui, deux jeunes soldats, Jan Kubis et Jozef Gabcik. L’un est tchèque, l’autre slovaque. Tous deux se sont engagés aux côtés de la Résistance, pour libérer leur pays de l’occupation allemande. Ils ont suivi un entraînement à Londres et se sont portés volontaires pour accomplir l’une des missions secrètes les plus importantes, et l’une des plus risquées aussi : éliminer Heydrich. Au cours de l’infiltration, Jan rencontre Anna Novak, tentant d’endiguer les sentiments qui montent en lui. Car les résistants le savent tous : leur cause passe avant leur vie. Le 27 mai 1942, les destins d’Heydrich, Jan et Jozef basculent, renversant le cours de l’Histoire. 
",15,50,"2016-01-01 00:00:00"),
(138,"Brimstone","Brimstone.jpg","Dans l’Ouest américain, à la fin du XIX siècle. Liz, une jeune femme d’une vingtaine d’années, mène une vie paisible auprès de sa famille. Mais sa vie va basculer le jour où un sinistre prêcheur leur rend visite. Liz devra prendre la fuite face à cet homme qui la traque sans répit depuis l’enfance… 
",15,50,"2016-01-01 00:00:00"),
(139,"Traque a boston","Traque-a-boston.jpg","Alors que la ville de Boston est sous le choc de multiples explosions, le sergent de police Tommy Saunders rejoint les enquêteurs sur le terrain dans une course contre la montre pour traquer et arrêter les auteurs avant qu'ils ne frappent à nouveau. Croisant les parcours de l'agent spécial Richard Deslauriers, du commissaire Ed Davis, du sergent Jeffrey Pugliese et de l'infirmière Carol Saunders, ce récit sans concession évoque la chasse à l'homme la plus complexe jamais mise en œuvre par la police américaine – et rend un vibrant hommage aux héros du quotidien.
",15,50,"2016-01-01 00:00:00");


--
-- Contenu de la table `category`
--

INSERT INTO `category` (`id`, `name`) VALUES 
(1, "Fantastique, Science-fiction"),
(2, "Comédie"),
(3, "Western"),
(4,"Action"),
(5,"Aventure"),
(6,"Drame"),
(7,"Documentaire"),
(8,"Thriller"),
(9,"Policier"),
(10,"Historique"),
(11,"Guerre"),
(12,"Romance");

--
-- Contenu de la table `movie_category`
--

INSERT INTO `movie_category` (`movie_id`, `category_id`) VALUES 
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1),
(7, 1),
(8, 1),
(9, 1),
(10, 1),
(11, 1),
(12, 1),
(13, 1),
(14, 1),
(15, 1),
(16, 1),
(17, 1),
(18, 1),
(19, 1),
(20, 1),
(21, 1),
(22, 1),
(23, 1),
(24, 1),
(25, 1),
(26, 1),
(27, 1),
(28, 1),
(29, 1),
(30, 1),
(31, 1),
(32, 1),
(33, 1),
(34, 1),
(35, 1),
(36, 1),
(37, 1),
(38, 2),
(100, 2),
(101, 2),
(102, 2),
(103, 2),
(104, 3),
(105, 3),
(106, 3),
(107,3),
(108,5),
(108,4),
(108,2),
(109,3),
(110,5),
(110,6),
(111,6),
(112,6),
(113,2),
(113,6),
(114,7),
(115,8),
(115,9),
(116,4),
(116,1),
(116,5),
(117,10),
(117,11),
(117,6),
(118,2),
(118,4),
(118,1),
(119,2),
(119,7),
(120,6),
(120,8),
(121,2),
(121,4),
(121,9),
(122,1),
(122,8),
(123,1),
(123,12),
(124,8),
(125,1),
(125,9),
(126,4),
(126,8),
(127,6),
(128,2),
(128,6),
(129,2),
(130,8),
(130,9),
(131,6),
(131,8),
(132,4),
(133,6),
(134,6),
(135,6),
(136,5),
(137,4),
(137,8),
(137,10),
(138,3),
(138,6),
(138,8),
(139,6),
(139,8)
;