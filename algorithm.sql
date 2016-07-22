show processlist;
SET GLOBAL event_scheduler = on;

DELIMITER $$

CREATE
	EVENT `scoreupdater`
	ON SCHEDULE EVERY 3 HOUR
	DO BEGIN
	

    DECLARE done INT DEFAULT FALSE;
    DECLARE myid INT;
    DECLARE myscore INT;
    DECLARE mytime TIMESTAMP;
    Declare tempscore decimal(10,8);
    Declare myvotes INT;
    Declare timediff INT;



    declare updateScore cursor for
    SELECT poll_id,score,alive,votes
    FROM poller.polls;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    open updateScore;

    myloop: LOOP

      SET myid=0;
      SET myscore=0;
      SET mytime=null;
      SET tempscore=0;

      fetch next from updateScore into myid, myscore,mytime,myvotes;

      IF done THEN
        LEAVE myloop;
      END IF;

      set timediff = TIMESTAMPDIFF(SECOND,mytime,now());
      set tempscore=LOG10(myvotes)-(timediff/1000);

      update poller.polls set score=tempscore,alive=mytime,votes=myvotes where id=myid;

    END LOOP;

   CLOSE updateScore;

END $$

DELIMITER ;