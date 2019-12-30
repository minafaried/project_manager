 --no task that depends on another task(s) allowed to start before these tasks are done firts.
 create function checkTaskTimeDependency()
 returns varchar(5) -- true or false.
 as
 begin
 
		-- gets the taskid of tasks that violates the dependency constrain ( startes before their tasks that they depends on finishes)
	if(
		exists( -- returns true of this query returns 1 or more record, i.e if there is a task that violate the constrain.
			select finalTable.taskId
			from	(select a.taskId, a.plannedStartDate, a.dependsONTaskId, Task.plannedDueDate
					 from		(select Task.taskId,Task. plannedStartDate, DEPENDS_ON.dependsONTaskId
								from Task, DEPENDS_ON
								where DEPENDS_ON.taskId = Task.taskId) as a
					 , Task
					where a.dependsONTaskId = Task.taskId) as finalTable
			where finalTable.plannedStartDate < finalTable.plannedDueDate
		)

		or 

		exists( -- same but for actualTime
			select finalTable.taskId
			from	(select a.taskId, a.actualStartDate, a.dependsONTaskId, Task.actualDueDate
					 from		(select Task.taskId,Task.actualStartDate, DEPENDS_ON.dependsONTaskId
								from Task, DEPENDS_ON
								where DEPENDS_ON.taskId = Task.taskId) as a
					 , Task
					where a.dependsONTaskId = Task.taskId) as finalTable
			where finalTable.actualStartDate < finalTable.actualDueDate
		)
	) 
	begin
		return 'false'
	end
	return 'true'


 end	
 

 
 -- constraint for subtasks start time >= parentTask startTime , subtasks endTime <= parentTaskEndTime.

/* select taskId
from	(select a1.taskId, a1. plannedStartDate, a1.plannedDueDate,a2.taskId as parentId ,
		 a2.plannedStartDate as ParentStart, a2.plannedDueDate as ParentDue
		from Task as a1, Task as a2
		where a1.parentTaskId = a2.taskId) as finalTable

where plannedStartDate
*/
 
 -- constraint for no teamMember works on 2 tasks at the same time ( [ start         XXXX[start end]               end ] 
 -- that is if he is working on a task, he wont work on another till he finishs it.
 
 