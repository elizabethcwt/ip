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
1. Adding a new task
   1. Adding a todo task: `todo`
   <br>Adds a todo task in your task list.
   <br>Format: `todo [todo task description]`
   <br>Examples: <br>
      1. `todo read book`
      <br>Expected output:
      <br>`Great! I've added this task:`
      <br>`[T][✘] read book`
      <br>`Now you have 2 task(s) in your list.`
      <br>
   
   1. Adding a deadline task: `deadline`
   <br>Adds a deadline task in your task list.
   <br>Format: `deadline [deadline task description] /by [deadline date]`
   <br>Entering a date in `YYYY-MM-DD` format converts the date to `MONTH DD YEAR` format.
   <br>Examples: <br>
      1. `deadline return book /by Sunday, 2pm`
      <br>Expected output:
      <br>`Great! I've added this task:`
	   <br>`[D][✘] return book  (by: Sunday, 2pm)`
      <br>`Now you have 1 task(s) in your list.`
      <br>
      
      1. `deadline return book /by 2pm, 2020-09-25`
      <br>Expected output:
      <br>`Great! I've added this task:`
      <br>`[D][✘] return book  (by: 2pm, Sep 25 2020)`
      <br>`Now you have 2 task(s) in your list.`
      <br>
   
   1. Adding an event task: `event`
   <br>Adds an event task in your task list.
   <br>Format: `event [event task description] /at [event location]`
   <br>Examples: <br>
      1. `event project meeting /at school`
      <br>Expected output:
      <br>`Great! I've added this task:`
	   <br>`[E][✘] project meeting  (at: school)`
      <br>`Now you have 1 task(s) in your list.`
      <br>
   
1. Feature 2:

### Feature 1 
Description of feature.
Expected outcome:
`outcome`

### Feature 2
Description of feature.

## Command Summary
