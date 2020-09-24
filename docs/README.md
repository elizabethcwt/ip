# User Guide

FriendlyBot is your friendly todo list, that helps you to **manage three types of tasks**:
* Todos,
* Deadlines, and
* Events

FriendlyBot provides several user commands, for more functionality when managing your tasks.
These commands are shown more clearly in the flowchart below.
<br><br>![FriendlyBot Basic Flowchart](https://github.com/elizabethcwt/ip/commit/25d3f2a5c9006f885a93c4ff70e6efeaec0be217)

## Quick Start
1. Ensure you have Java `11` or above installed in your Computer.
1. Download the latest `ip.jar` from [here](https://github.com/elizabethcwt/ip/releases/tag/A-Jar). (Not updated)
1. Copy and place the file into a folder on your computer.
1. Open your computer's terminal, navigate to the `ip.jar` file and run the app.
1. Refer to the features below for details of the commands available in FriendlyBot.

## Features
### Adding a new task
#### Adding a todo task: `todo`
Adds a todo task in your task list.
<br>Format: `todo [todo task description]`
<br>Examples:
<br>
Input: `todo read book`
<br>Expected output:
<br>`Great! I've added this task:`
<br>`[T][✘] read book`
<br>`Now you have 2 task(s) in your list.`

Note:
* `[T]` - Task is of **todo** type.
* `[✘]` - Task is **not done**.
   
#### Adding a deadline task: `deadline`
Adds a deadline task in your task list.
<br>Format: `deadline [deadline task description] /by [deadline date]`
<br>Entering a date in `YYYY-MM-DD` format converts the date to `MONTH DD YEAR` format.
<br>Examples:
<br>
Input: `deadline return book /by Sunday, 2pm`
<br>Expected output:
<br>`Great! I've added this task:`
<br>`[D][✘] return book  (by: Sunday, 2pm)`
<br>`Now you have 1 task(s) in your list.`
    
Input: `deadline return book /by 2pm, 2020-09-25`
<br>Expected output:
<br>`Great! I've added this task:`
<br>`[D][✘] return book  (by: 2pm, Sep 25 2020)`
<br>`Now you have 2 task(s) in your list.`
  
Note:
* `[D]` - Task is of **deadline** type.
* `[✘]` - Task is **not done**.

#### Adding an event task: `event`
Adds an event task in your task list.
<br>Format: `event [event task description] /at [event location]`
<br>Examples:
<br>
Input: `event project meeting /at school`
<br>Expected output:
<br>`Great! I've added this task:`
<br>`[E][✘] project meeting  (at: school)`
<br>`Now you have 1 task(s) in your list.`

Note:
* `[E]` - Task is of **event** type.
* `[✘]` - Task is **not done**.
   
### Check/Update an existing task
#### Listing all tasks: `list`
Lists all the tasks (todo, deadline and event) in your current task list.
<br>Format: `list`
<br>Examples:
<br>
Input: `list`
<br>Expected output:
<br>`Here is/are the task(s) in your list:`
<br>`1.[D][✘] return book  (by: Sunday, 2pm)`
<br>`2.[D][✘] return book  (by: 2pm, Sep 25 2020)`
<br>`3.[E][✘] project meeting  (at: school)`

#### Marking tasks as done: `done`
Marks specific task in your task list as done.
<br>Format: `done [task number in task list]`
<br>Examples:
<br>
Input: `done 3`
<br>Expected output:
<br>`Good job! :) I've marked this task as complete:`
<br>`[E][✓] project meeting  (at: school)`

Note:
* `[✓]` - Task is **done**.

#### Deleting a task: `delete`
Deletes a specific task in your current task list.
<br>Format: `done [task number in task list]`
<br>Examples:
<br>
Input: `delete 2`
<br>Expected output:
<br>`Alrighttt, I've successfully removed this task:`
<br>`[D][✘] return book  (by: 2pm, Sep 25 2020)`
<br>`Now you have a grand total of... 2 task(s) in your list! 👍🏼`
    
#### Finding a task: `find`
Finds relevant tasks in your current task list based on keywords you provide.
<br>Format: `find [keyword(s)]`
<br>Examples:
<br>
Input: `find book`
<br>Expected output:
<br>`Here is/are the relevant task(s) in your list:`
<br>`1. [D][✘] return book  (by: Sunday, 2pm)`

###
#### Exiting the program: `bye`
Exits FriendlyBot.
<br>Examples:
<br>
Input: `bye`
<br>Expected output:
<br>`Hope you found this app useful! `
<br>`See you again! :)`

## Command Summary
|Action|Format|
|--------------|----------------|
|Add todo|`todo [todo task description]`|
|Add deadline|`deadline [deadline task description] /by [deadline date]`|
|Add event|`deadline [event task description] /at [event location]`|
|List|`list`
|Done|`done [task number in task list]`|
|Delete|`delete [task number in task list]`|
|Find|`find [keyword(s)]`|
|Bye|`bye`|
