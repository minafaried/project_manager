CREATE TABLE [Task] (
  [taskId] int,
  [workingHours] int,
  [plannedStartDate] varchar(20),
  [plannedDueDate] varchar(20),
  [actualStartDate] varchar(20),
  [actualDueDate] varchar(20),
  [parentTaskId] int,
  PRIMARY KEY ([taskId])
);

CREATE TABLE [teamMember] (
  [teamMemberId] int,
  [name] varchar(20),
  [title] varchar(20),
  [workingHours] int,
  PRIMARY KEY ([teamMemberId])
);

CREATE TABLE [mileStone] (
  [mileStoneId] int,
  [name] varchar(20),
  [date] varchar(20),
  PRIMARY KEY ([mileStoneId])
);

CREATE TABLE [DEPENDS_ON] (
  [taskId] int REFERENCES Task(taskId),
  [dependsONTaskId] int REFERENCES Task(taskId)
  PRIMARY KEY(taskId, dependsONTaskId) 

);


CREATE TABLE [WORKS_ON] (
  [taskId] int REFERENCES Task(taskId),
  [teamMemberId] int REFERENCES teamMember(teamMemberId) ,
  [workingDays] int

  PRIMARY KEY(taskId, teamMemberId)
);



