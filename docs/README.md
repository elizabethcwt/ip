# User Guide

*  [Introduction and Flowchart](#introduction-and-flowchart)
*  [Quick Start](#quick-start)
*  [Features](#features)
   *  [Adding a new task](#adding-a-new-task): `todo` `deadline` `event`
   *  [Check/Update an existing task](#check/update-an-existing-task): `list` `done` `delete` `find`
   *  [Exiting the program](#exiting-the-program): `bye`
   *  [Saving Data](#saving-data)
*  [Command Summary](#command-summary)

<a id="introduction-and-flowchart"></a>
## Introduction and Flowchart
FriendlyBot is your friendly todo list, that helps you to **manage three types of tasks**:
* Todos,
* Deadlines, and
* Events

FriendlyBot provides several user commands, for more functionality when managing your tasks.
These commands are shown more clearly in the flowchart below.
<br><br><img src="FriendlyBot%20Basic%20Flowchart.png" style = "width=300"/>

<a id="quick-start"></a>
## Quick Start
1. Ensure you have Java `11` or above installed in your Computer.
1. Download the latest `ip.jar` from [here](https://github.com/elizabethcwt/ip/releases/tag/A-Release).
1. Copy and place the file into a folder on your computer.
1. Open your computer's terminal, navigate to the `ip.jar` file and run the app.
1. Refer to the features below for details of the commands available in FriendlyBot.

<a id="features"></a>
## Features

<a id="adding-a-new-task"></a>
### Adding a new task
#### Adding a todo task: `todo`
Adds a todo task in your task list.
<br>Format: `todo [todo task description]`
<br>Examples:
<br>
Input: `todo read book`
<br>Expected output:
<br><img src="todo.png" width="350"/>

Note:
* `[T]` - Task is of **todo** type.
* `[N]` - Task is **not done**.
   
#### Adding a deadline task: `deadline`
Adds a deadline task in your task list.
<br>Format: `deadline [deadline task description] /by [deadline date]`
<br>Entering a date in `YYYY-MM-DD` format converts the date to `MONTH DD YEAR` format.
<br>Examples:
<br>
Input: `deadline return book /by Sunday, 2pm`
<br>Expected output:
<br><img src="deadline1.png" width="425"/>
    
Input: `deadline return book /by 2pm, 2020-09-25`
<br>Expected output:
<br><img src="deadline2.png" width="475"/>
  
Note:
* `[D]` - Task is of **deadline** type.
* `[N]` - Task is **not done**.

#### Adding an event task: `event`
Adds an event task in your task list.
<br>Format: `event [event task description] /at [event location]`
<br>Examples:
<br>
Input: `event project meeting /at school`
<br>Expected output:
<br><img src="event.png" width="425"/>

Note:
* `[E]` - Task is of **event** type.
* `[N]` - Task is **not done**.
   
<a id="check/update-an-existing-task"></a>
### Check/Update an existing task
#### Listing all tasks: `list`
Lists all the tasks (todo, deadline and event) in your current task list.
<br>Format: `list`
<br>Examples:
<br>
Input: `list`
<br>Expected output:
<br><img src="list.png" width="425"/>

#### Marking tasks as done: `done`
Marks specific task in your task list as done.
<br>Format: `done [task number in task list]`
<br>Examples:
<br>
Input: `done 1`
<br>Expected output:
<br><img src="done1.png" width="450"/>

Note:
* `[Y]` - Task is **done**.

#### Deleting a task: `delete`
Deletes a specific task in your current task list.
<br>Format: `done [task number in task list]`
<br>Examples:
<br>
Input: `delete 2`
<br>Expected output:
<br><img src="delete2.png" width="550"/>
    
#### Finding a task: `find`
Finds relevant tasks in your current task list based on keywords you provide.
<br>Format: `find [keyword(s)]`
<br>Examples:
<br>
Input: `find book`
<br>Expected output
<br><img src="find.png" width="450"/>

<a id="exiting-the-program"></a>
### Exiting the program: `bye`
Exits FriendlyBot.
<br>Examples:
<br>
Input: `bye`
<br>Expected output:
<br><img src="bye.png" width="290"/>

<a id="saving-data"></a>
### Saving Data
The tasks that you have added, deleted, or edited in any way will be saved externally in a file.
<br>If this file doesn't already exist in your computer, a new file will be created.
<br>When you re-run FriendlyBot, the data (i.e. tasks in your friendly task list) will be loaded, and entering the `list` command will trigger the display of your updated task list, where you left off previously.

<a id="command-summary"></a>
## Command Summary

|Action|Format|Examples|
|--------------|----------------|----------------|
|Add todo|`todo [todo task description]`|`todo read book`|
|Add deadline|`deadline [deadline task description] /by [deadline date]`|`deadline return book /by 2pm, 2020-09-25`|
|Add event|`deadline [event task description] /at [event location]`|`event project meeting /at school`|
|List|`list`|
|Done|`done [task number in task list]`|`done 2`|
|Delete|`delete [task number in task list]`|`delete 2`|
|Find|`find [keyword(s)]`|`find book`|
|Bye|`bye`|
