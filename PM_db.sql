CREATE TABLE [Task] (
  [taskId] int,
  [workingHours] int Not NULL,
  [plannedStartDate] dateTime not null, 
  [plannedDueDate] dateTime not null,
  [actualStartDate] dateTime not null,
  [actualDueDate] dateTime not null,
  [parentTaskId] int,
  PRIMARY KEY ([taskId])
);

CREATE TABLE [teamMember] (
  [teamMemberId] int,
  [name] varchar(20) not null,
  [title] varchar(20) not null,
  [workingHours] int not null,
  PRIMARY KEY ([teamMemberId])
);

CREATE TABLE [mileStone] (
  [mileStoneId] int,
  [name] varchar(20) not null,
  [date] dateTime not null,
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



