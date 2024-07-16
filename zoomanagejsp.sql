CREATE database `zoomanagejsp`;
use `zoomanagejsp`;

CREATE TABLE `admin` (
  `username` VARCHAR(50) NOT NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`username`));

INSERT INTO `admin` (`username`, `password`) VALUES ('admin', 'admin');

--
-- Table structure for table `animal`
--

DROP TABLE IF EXISTS `animal`;

CREATE TABLE `animal` (
  `id` int NOT NULL AUTO_INCREMENT,
  `AnimalName` varchar(200) DEFAULT NULL,
  `CageNumber` varchar(100) DEFAULT NULL,
  `FeedNumber` varchar(100) DEFAULT NULL,
  `Breed` varchar(200) DEFAULT NULL,
  `photo` varchar(45) DEFAULT NULL,
  `Description` varchar(300) DEFAULT NULL,
  `CreationDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
);

INSERT INTO `animal` VALUES (1,'Elephant','1001','FN00101','Borneo elephant','1.jpg','The Borneo elephant is found in the northern and northeastern sections of the island of Borneo in Malaysia and Indonesia.','2022-01-17 07:49:35'),(2,'Zebra','10058','FN112200','Indian Zebra','2.jpg','Zebras are single-hoofed animals that are native to Africa. Zebras are very closely related to horses and donkeys; in fact, they are in the same genus, Equus.','2022-01-18 08:30:42'),(3,'Rhino Big','11100','FN1320','rhino-big','3.jpg','Sumatran rhinos are the smallest, but they can still weigh 600kg (that\'s almost 95 stone). And white rhinos are the largest, weighing up to 3,500kg (over 550 stone, or well over 3 tonnes!). ','2022-01-18 08:31:58'),(4,'San Diego Zoo','142536','FN1234','san diego','4.jpg','The San Diego Zoo is a zoo in Balboa Park, San Diego,housing over 12,000 animals of more than 650 species and subspecies on 100 acres of Balboa Park leased from the City of San Diego.','2022-01-18 08:34:09');

--
-- Table structure for table `ticforeigner`
--

DROP TABLE IF EXISTS `ticforeigner`;
  
  
CREATE TABLE `ticforeigner` (
  `id` int NOT NULL AUTO_INCREMENT,
  `TicketID` varchar(100) DEFAULT NULL,
  `NoAdult` varchar(100) DEFAULT NULL,
  `NoChildren` varchar(100) DEFAULT NULL,
  `AdultUnitprice` varchar(100) DEFAULT NULL,
  `ChildUnitprice` varchar(100) DEFAULT NULL,
  `PostingDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
);

INSERT INTO `ticforeigner` VALUES (3,'7362829','2','3','1500','450','2022-01-17 11:52:06');

--
-- Table structure for table `tickettype`
--

DROP TABLE IF EXISTS `tickettype`;
  
CREATE TABLE `tickettype` (
  `tid` int NOT NULL AUTO_INCREMENT,
  `TicketType` varchar(150) DEFAULT NULL,
  `Price` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`tid`)
);

INSERT INTO `tickettype` VALUES (1,'Native Adult','500'),(2,'Native Child','120'),(3,'Foreigner Adult','1500'),(4,'Foreigner Child','450');

--
-- Table structure for table `ticindian`
--

DROP TABLE IF EXISTS `ticindian`;
 
CREATE TABLE `ticindian` (
  `id` int NOT NULL AUTO_INCREMENT,
  `TicketID` int DEFAULT NULL,
  `NoAdult` varchar(100) DEFAULT NULL,
  `NoChildren` varchar(100) DEFAULT NULL,
  `AdultUnitprice` varchar(100) DEFAULT NULL,
  `ChildUnitprice` varchar(100) DEFAULT NULL,
  `PostingDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
);

INSERT INTO `ticindian` VALUES (7,18245606,'3','2','500','120','2022-01-17 11:45:47');

--
-- Table structure for table `contacts`
--

DROP TABLE IF EXISTS `contacts`;

CREATE TABLE `contacts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(250) DEFAULT NULL,
  `emailid` varchar(50) DEFAULT NULL,
  `contact` varchar(15) DEFAULT NULL,
  `message` varchar(300) DEFAULT NULL,
  `msgDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `isRead` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `contacts` VALUES (1,'Abhijit Sukla','abhijit123@gmail.com','1234567890','I want Purchase the zoo ticket.','2022-01-18 07:46:15','yes');
