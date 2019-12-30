
 alter table Depends_On
 add constraint taskTimeDependency check(dbo.checkTaskTimeDependency() = 'true')
 


 alter table Task
 add constraint endBiggerThanStart check( plannedDueDate > plannedStartDate and actualDueDate > actualStartDate )



