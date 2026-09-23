DEPARTMENT OF COMPUTATIONAL SCIENCE
 
UNIVERSITY OF FORT HARE
Together in Excellence
UFH-NESTLINK
DIGITAL RESIDENCE INVENTORY AND MAINTENANCE MANAGEMENT SYSTEM

A detailed software project assignment documenting the final implemented system
DUE DATE: 23 SEPTEMBER 2026
GROUP 11 MEMBERS
PHANDLE, SIBONGILE – 225025999	MNDELA, NKCUBEKO – 225032049
NGUBELANGA, ANOYOLO – 224066627	NOMANDELA, T – 224027811
SIPHUNGU, PHELISWA – 225033718	VANQA, SOMILA – 202249895
MAJAKU, AVELILE – 202343766	NTLONTI, EY – 202210889
MPUKWANA, BATHANDE – 224056061	TINISE, ASENATHI – 202230751
VELEMBO, LIZALISWE – 224066467	TENGWA, S – 224017897
NCEBO, ANELISIWE – 224059296	MTYHALEKA, ELETHU – 223022436
 
PROJECT DECLARATION AND POSITIONING
This document describes the final UFH-NestLink system that was actually designed and implemented. The original assignment proposal was useful as an early planning document, but the finished software changed in several important ways as the team moved from an idea to a working application. For that reason, this assignment focuses on the final digital inventory process, the real user roles, the database structure, the maintenance workflow, the security decisions, the tools used and the lessons learned during implementation.
The central purpose of the project is to replace a paper-based residence inventory process with a digital process. In the manual process, a student signs a paper inventory, physically hands it to a matron or residence representative, and the document is then transported to residence administration. At every hand-over there is a risk of delay, loss, duplication or a problem not being followed up. UFH-NestLink removes most of those hand-offs by letting the student complete, sign and submit the inventory electronically. Residence Staff can review it immediately, and any reported faults can be forwarded to Maintenance through the same system.
The system is therefore not only an inventory checklist. It is also a traceable communication and maintenance workflow. Students can be heard without repeatedly carrying paper forms from office to office, Residence Staff can see what has been submitted, and Maintenance Staff can accept, schedule, start and complete work while the system keeps a history of what happened.
 
TABLE OF CONTENTS
•	1. Introduction
•	2. Problem Statement and Motivation
•	3. Aim, Objectives, Scope and Significance
•	4. Development Journey: From Proposal to Final System
•	5. Final System Overview and User Roles
•	6. Functional Requirements and Key Functions
•	7. Six Quality Requirements and Their Implementation
•	8. System Architecture and Network Design
•	9. Database Design and Data Management
•	10. Algorithms and Business Logic
•	11. Technologies, Languages and Tools Used
•	12. System Execution and Demonstration
•	13. Security Implementation
•	14. Testing and Evaluation
•	15. Use of Artificial Intelligence as a Learning Tool
•	16. Challenges, Limitations and Future Improvements
•	17. Conclusion
•	References
•	Appendix A: Execution Commands
•	Appendix B: Functional Test Checklist
 
1. INTRODUCTION
1.1 Background
Student residences depend on accurate room inventory records because the condition of beds, desks, cupboards, lights, plugs, windows and other items affects both students and the institution. Traditionally, this information is often collected on paper. A student signs the inventory, gives it to a matron or residence representative, and the document is then sent to the residence office. The process looks simple, but it creates several practical problems: papers can be misplaced, handwriting can be unclear, damaged items can be reported late, and students have no direct way to see whether their report was received or attended to.
UFH-NestLink was developed to digitise this process. Instead of moving a physical inventory sheet between people, the student uses a web application. The signed inventory is stored in a database and becomes visible to Residence Staff. If an item is damaged or missing, the system records the fault and allows Residence Staff to forward it to Maintenance. Maintenance Staff then work through a controlled sequence of accepting the job, scheduling a room visit, starting the work and completing it with a resolution note. Notifications and status history make the process traceable.
This final implementation differs from the early proposal in a useful way: it is closer to the real residence workflow. The matron/residence administration function is represented by the Residence Staff role, while maintenance execution is handled through the Maintenance Staff portal rather than a separate technician portal. This reduces unnecessary role complexity while keeping accountability.
1.2 Project Title
UFH-NestLink: Digital Residence Inventory and Maintenance Management System.
2. PROBLEM STATEMENT AND MOTIVATION
The main problem is not simply that the residence inventory is on paper; the problem is that the entire communication chain depends on physical movement and manual administration. A student may identify a broken or missing item, sign the inventory and submit it, but the information still has to move through several people before maintenance work begins. During this process a form can be lost, forgotten, duplicated or placed in the wrong file. A student may then have to report the same problem again, and staff may have difficulty proving when the issue was first submitted.
The lack of a central digital record also makes accountability difficult. Residence Staff need to know which inventory checks are still outstanding, which have been signed, and which contain faults. Maintenance Staff need a clear queue of work, not informal messages passed through different channels. Students need feedback so that they know their matter has not disappeared. The project therefore addresses a communication, record-keeping and service-delivery problem at the same time.
2.1 Why a Digital Inventory System Was Chosen
•	A digital submission reaches Residence Staff immediately after the student submits it; there is no need to physically carry the signed form to another office.
•	A database keeps a persistent record of the inventory, fault and status changes, reducing the risk of losing the only copy of a report.
•	Residence Staff can review signed inventories and forward faults from one dashboard.
•	Maintenance Staff can see a structured queue and record each stage of the job.
•	Students receive status updates and can see that the issue has entered the maintenance process.
•	The same platform can later be extended to more residences, more inventory items and more staff without redesigning the whole process.
3. AIM, OBJECTIVES, SCOPE AND SIGNIFICANCE
3.1 Aim
The aim of UFH-NestLink is to design and implement a secure web-based digital residence inventory system that allows students to sign and submit room inventory electronically, enables Residence Staff to review and manage those submissions, and creates a traceable maintenance workflow for reported faults.
3.2 Objectives
•	Digitise the student room inventory so that it can be completed and submitted online.
•	Record the condition of room items in a structured database rather than only on paper.
•	Allow Residence Staff to allocate students to rooms and review submitted inventory checks.
•	Automatically associate damaged or missing inventory items with maintenance reports when maintenance action is required.
•	Allow Residence Staff to forward relevant faults to the Maintenance Department.
•	Provide a Maintenance Staff portal for accepting jobs, scheduling visits, starting work and recording completion.
•	Provide status history, in-app notifications and optional email notifications so that communication is traceable.
•	Protect accounts and data using hashed passwords, authenticated sessions and role-based access control.
•	Provide a responsive, straightforward user interface for students and staff.
•	Use Git and GitHub to maintain a controlled version history of the software.
3.3 Scope
The implemented system is scoped to UFH student residences represented in the project database. It manages users, residences, rooms, room allocations, inventory items, inventory submissions, reported faults, maintenance assignments, scheduled visits, status history and notifications. The system runs as a local web application during development and can later be deployed to an institutional server.
3.4 Significance
The project improves service delivery by shortening the distance between a student's report and the staff member who must act on it. It also creates an evidence trail. A signed inventory can be reviewed later, a fault has a reference code and status, and maintenance actions have timestamps and history. This is important for fairness because both students and staff can work from the same stored record instead of relying on memory or paper movement.
4. DEVELOPMENT JOURNEY: FROM PROPOSAL TO FINAL SYSTEM
The first assignment proposal described a three-user system with Student, Maintenance and Technician roles, OTP onboarding, proof-of-residence approval, automatic complaint classification and technician assignment. Those ideas helped define the problem, but the final software was simplified and aligned more closely with the implemented residence process. The finished application uses Student, Residence Staff and Maintenance Staff roles, direct UFH-email registration for students, controlled staff-account creation, signed inventory review by Residence Staff, and explicit forwarding of faults to Maintenance.
Area	Early proposal	Final implemented UFH-NestLink
Staff roles	Maintenance + separate Technician	Residence Staff + Maintenance Staff
Student onboarding	OTP and proof of residence approval	UFH email + password registration; role stored in database
Inventory hand-off	Complaint sent directly to Maintenance	Signed inventory is reviewed by Residence Staff, then faults are forwarded
Maintenance assignment	Automatic technician selection	Maintenance Staff accept a forwarded job and become responsible for it
Job lifecycle	Pending → Assigned → Completed	Submitted → Forwarded → Acknowledged/Accepted → Scheduled → In Progress → Completed
Notifications	General completion notification	In-app notifications plus development/SMTP email events at workflow stages
Staff administration	Not central to proposal	Residence Staff can create, activate and deactivate staff accounts
These changes are not failures of the original design. They demonstrate iterative software development: the team refined the model after working with the actual user flow, database constraints and interface needs. Software engineering commonly involves revising early requirements as a system becomes more concrete (Sommerville, 2016).
5. FINAL SYSTEM OVERVIEW AND USER ROLES
 
Figure 1. Final digital inventory and maintenance workflow.
5.1 Student Role
•	Registers using an eligible UFH email address and a password.
•	Logs in and sees the Student Residence Portal.
•	Views the room/residence allocated to the student.
•	Completes the room inventory checklist and records the condition of items.
•	Signs/submits the inventory digitally, replacing the physical paper hand-over.
•	Can create or trigger maintenance reports for damaged/missing items that require attention.
•	Can view maintenance status and notifications so the issue is not invisible after submission.
5.2 Residence Staff Role
•	Logs in to a residence-specific staff dashboard.
•	Views rooms and students within the staff member’s assigned residence.
•	Manages room allocations.
•	Reviews signed inventory submissions and their reported faults.
•	Verifies inventory records and forwards relevant faults to Maintenance.
•	Views a maintenance log for the residence.
•	Manages staff accounts through the Staff Management page, including creation and activation/deactivation where allowed.
5.3 Maintenance Staff Role
•	Uses a dedicated Maintenance Department Portal.
•	Views forwarded maintenance jobs in a queue.
•	Accepts a job, which records the responsible maintenance user.
•	Schedules a future room visit with a date, time and estimated duration.
•	Starts work only after the visit/job is in the correct scheduled state.
•	Completes the job by entering a resolution note.
•	Can review visit history and status history for accountability.
6. FUNCTIONAL REQUIREMENTS AND KEY FUNCTIONS
ID	Requirement	Description	Status
FR1	Authentication	The system shall allow authorised users to sign in and sign out using an account stored in the database.	Implemented
FR2	Student registration	The system shall allow eligible students to create accounts using UFH email addresses.	Implemented
FR3	Role-based portals	Student, Residence Staff and Maintenance Staff shall receive different interfaces and permissions.	Implemented
FR4	Room allocation	Residence Staff shall be able to manage student-room allocations in their residence.	Implemented
FR5	Digital inventory	A student shall be able to complete, sign and submit the room inventory electronically.	Implemented
FR6	Inventory review	Residence Staff shall be able to view and review signed inventory checks.	Implemented
FR7	Fault reporting	Damaged/missing inventory issues shall be stored as maintenance reports where required.	Implemented
FR8	Forwarding	Residence Staff shall be able to forward submitted faults to Maintenance.	Implemented
FR9	Maintenance acceptance	Maintenance Staff shall be able to accept forwarded jobs.	Implemented
FR10	Visit scheduling	Maintenance Staff shall be able to schedule room visits for accepted jobs.	Implemented
FR11	Progress updates	Maintenance Staff shall be able to start and complete work through controlled status transitions.	Implemented
FR12	Notifications	The system shall inform relevant users when important workflow changes occur.	Implemented
FR13	Status history	The system shall retain a history of maintenance status changes.	Implemented
FR14	Staff management	Residence Staff shall be able to create and manage appropriate staff accounts.	Implemented
FR15	Data persistence	User, inventory and maintenance information shall remain stored in a database.	Implemented
6.1 Key Function: Digital Inventory Submission
This is the core function of the project. The student no longer signs a sheet and physically transports it. The browser sends the submitted inventory to the backend API, the backend validates the authenticated student and room relationship, and the database stores the inventory check and item-level conditions. Because the submission is stored centrally, Residence Staff can see it without waiting for a paper form.
6.2 Key Function: Controlled Maintenance Forwarding
A fault is not silently passed from person to person. Residence Staff deliberately forward inventory faults to Maintenance. The server creates a MaintenanceAssignments record, updates the MaintenanceReports status to forwarded, writes a status-history record and creates notifications. The forwarding process is performed as a database transaction so that related updates succeed together rather than leaving a partially updated workflow.
6.3 Key Function: Maintenance Lifecycle
Maintenance uses explicit status rules. A newly forwarded job must first be accepted. An accepted job can be scheduled. A scheduled job can be started. An in-progress job can be completed only after a resolution note is entered. These rules prevent staff from accidentally skipping important stages and they make the status meaningful to students and Residence Staff.
7. SIX QUALITY REQUIREMENTS AND HOW THEY WERE IMPLEMENTED
Quality requirement	Meaning in this project	Implementation
1. Functional competence and correctness	The software must do the intended residence work correctly.	Role-specific routes, validation, allowed status transitions, room/residence checks and database transactions were used so that actions happen in the right order and on the right records.
2. Security and privacy	Accounts and residence information must not be open to unauthorised users.	Passwords are hashed with bcrypt rather than stored as plain text. Sessions identify the logged-in user. Middleware restricts Student, Residence Staff and Maintenance Staff routes. Public registration does not freely create staff roles.
3. Reliability and availability	Submitted records should not disappear when the page changes or the user logs out.	SQLite stores records persistently. Important multi-record operations use transactions. The database includes status/history records instead of relying only on temporary screen state.
4. Usability and accessibility	The system should be straightforward for students and staff who are not technical users.	The interface uses clear portals, cards, status labels, simple forms and responsive layouts. Each role sees only the functions relevant to that role, reducing clutter.
5. Safety and data integrity	The system should avoid unsafe or inconsistent changes to residence and maintenance records.	Input validation, residence scoping, role checks and workflow-state checks prevent invalid actions. The maintenance schedule must be a future date/time, and completion requires a resolution note.
6. Maintainability and scalability	The project should be understandable and extendable after the assignment.	The code is separated into routes, helper modules, database functions, email logic and frontend role modules. Git/GitHub provide version history. SQLite is suitable for the current project and can later be replaced by a larger database if deployment scale grows.
8. SYSTEM ARCHITECTURE AND NETWORK DESIGN
 
Figure 2. UFH-NestLink client-server architecture.
8.1 Client-Server Architecture
UFH-NestLink follows a client-server architecture. The client side is the web browser, which displays HTML and applies CSS/JSS styles while JavaScript handles user interaction and calls the backend API. The backend runs on Node.js with Express. It checks sessions and roles, applies business rules, reads/writes SQLite data and triggers notifications. Node.js is a JavaScript runtime, which allowed the project to use JavaScript on both the browser and server sides (Node.js, 2026). Express was chosen because it provides lightweight routing and middleware for Node.js web applications (Express.js, 2026).
8.2 Development Network Execution
During development the application runs locally at http://localhost:3000. This means the browser and server are on the same computer. In a production deployment, the same application could be hosted on a university server and accessed through HTTPS. HTTPS is therefore a deployment requirement and recommendation; it should not be falsely described as already enabled in the local development environment.
8.3 Communication Flow
1.	A user opens UFH-NestLink in a browser.
2.	The frontend sends an HTTP request to an API route such as /api/auth, /api/student, /api/residence, /api/maintenance or /api/staff.
3.	Express middleware verifies the session and checks the required role.
4.	The route validates the request and reads or changes data in SQLite.
5.	The server returns JSON or a success/error response to the frontend.
6.	The interface updates and, where necessary, the system creates an in-app notification or sends/logs an email event.
9. DATABASE DESIGN AND DATA MANAGEMENT
SQLite was selected because it provides a full relational SQL database without requiring a separate database server process. It is self-contained, transactional and zero-configuration, which makes it suitable for a university software project and local demonstration environment (SQLite, 2026). The project database is stored as a file during development, while the application accesses it through a database helper module.
 
Figure 3. Simplified overview of the major data relationships.
Table / Entity	Purpose
Users	Stores students and staff, email, password hash, role, residence link where applicable, active status and login metadata.
Residences	Stores residence names and activation information.
Rooms	Stores room numbers and links each room to a residence.
RoomAllocations	Connects students to rooms and provides the basis for student room access.
ItemCatalog	Defines inventory item types used by the system.
RoomInventory	Connects catalogue items to specific rooms.
InventoryChecks	Stores each student inventory submission, its status and signing/submission information.
InventoryCheckItems	Stores the condition and report choice for every inventory item in a check.
MaintenanceCategories	Stores maintenance categories and related service information.
MaintenanceReports	Stores fault reference, title, description, priority and status.
MaintenanceAssignments	Records forwarding information, responsible maintenance user and assignment status.
MaintenanceVisits	Stores scheduled visit date/time, duration, notes and visit status.
MaintenanceStatusHistory	Keeps the sequence of status changes, who changed them and the note.
Notifications	Stores messages shown to students/staff when workflow events occur.
9.1 Why Database Transactions Matter
Some actions change more than one table. For example, forwarding a fault creates an assignment, updates the report status, adds a status-history entry and creates notifications. These operations are grouped in a database transaction so that the system does not save only half of the action if an error occurs. This contributes to data integrity and reliability.
10. ALGORITHMS AND BUSINESS LOGIC
10.1 Authentication Algorithm
7.	Receive email and password from the login form.
8.	Normalise the email and find the corresponding active user record.
9.	Compare the entered password with the stored bcrypt hash.
10.	If the comparison succeeds, create a server session containing the user identity and role.
11.	Return the user profile so the frontend loads the correct portal.
12.	If authentication fails, return an error without exposing the stored password or hash.
10.2 Inventory Submission Algorithm
13.	Confirm that the request comes from an authenticated Student.
14.	Find the student’s allocated room and valid room inventory.
15.	Record item conditions selected by the student.
16.	Store the signed/submitted inventory check.
17.	For items that require maintenance, create or link a maintenance report as required by the inventory logic.
18.	Make the signed check available to Residence Staff for review.
10.3 Residence Fault Forwarding Algorithm
19.	Residence Staff opens a signed inventory or maintenance record within the assigned residence.
20.	The server checks that the record belongs to that residence.
21.	The system finds submitted faults that have not already been forwarded.
22.	For each fault, create a MaintenanceAssignments record with assignment_status = forwarded.
23.	Update the MaintenanceReports status to forwarded.
24.	Insert a status-history record and create notifications for the student and active Maintenance Staff.
25.	After the database transaction succeeds, trigger the email notification process.
10.4 Maintenance Execution Algorithm
26.	Forwarded → Maintenance Staff accepts the job.
27.	Accepted → Maintenance Staff schedules a future room visit.
28.	Scheduled → The assigned Maintenance Staff member starts work.
29.	In Progress → Maintenance Staff enters a resolution note and completes the job.
30.	The report, assignment, visit and status history are updated together where applicable.
31.	The student receives notifications as the job progresses.
11. TECHNOLOGIES, LANGUAGES AND TOOLS USED
Technology / Tool	Used for	Why it was used
HTML5	Frontend structure	Used to define the page structure, forms, tables, navigation, buttons and modal content. In simple terms, HTML is the skeleton of the website.
CSS / JavaScript-injected styles	Frontend presentation	Used for UFH blue/gold branding, responsive layouts, cards, tables, forms and modal design. CSS controls how the application looks.
JavaScript (browser)	Frontend behaviour	Used to open pages, submit forms, call APIs, render data, validate simple interactions and switch between role views.
JavaScript (Node.js)	Backend language	The same core language was used on the server. Node.js executes JavaScript outside the browser, allowing the team to build the server without learning a second backend language.
Express.js	Backend web framework	Used to create API routes, middleware and server endpoints. It handles requests such as login, inventory submission and maintenance updates.
SQLite	Database	Used to persist users, rooms, inventory checks, faults, assignments, visits and notifications in relational tables.
bcrypt	Password protection	Used to hash passwords before they are stored. The original password is not kept in plain text.
express-session	Login session management	Used to remember the authenticated user between requests and support server-side role checking.
Nodemailer	Email integration	Used for maintenance workflow email messages. During development, email mode can log messages to the terminal; SMTP can be configured for real delivery.
VS Code	Development environment	Used to create, edit and organise JavaScript, HTML, styles and configuration files.
Git Bash	Command-line tool	Used to run Node/npm commands, check syntax and execute Git commands.
Git and GitHub	Version control	Used to save versions of the source code, track changes and push the updated project to a shared remote repository.
Browser Developer Tools	Testing/debugging	Used to inspect the interface, refresh cached frontend code and check console/network errors.
npm	Package manager	Used to install and manage Node.js dependencies and run project scripts.
11.1 Why JavaScript Was Practical for This Project
Using JavaScript in both the frontend and backend reduced context switching for the team. The browser already requires JavaScript for interactive behaviour, and Node.js makes it possible to use JavaScript for server-side code as well. This made concepts such as objects, arrays, asynchronous requests and JSON reusable across the whole application.
12. SYSTEM EXECUTION AND DEMONSTRATION
12.1 Development Environment
The system was developed on Windows using Visual Studio Code and Git Bash. The final development environment used Node.js v24.21.0 and npm v11.19.0. The backend runs on port 3000. The SQLite database is stored locally during development, and the application exposes separate API groups for Student, Residence, Maintenance and Staff operations.
12.2 First-Time Setup
32.	Open the project folder in VS Code.
33.	Install dependencies with npm install.
34.	Create the local environment configuration (.env) using non-secret development values and keep the real .env out of Git.
35.	Initialise the database once with npm run init-db when starting with a new empty development database.
36.	Start the application with npm start.
37.	Open http://localhost:3000 in a web browser.
12.3 Normal Execution
After the database already exists, normal execution does not require reinitialising it. The developer starts the server with npm start. The terminal confirms the application URL and API groups. Re-running database initialisation on an active project would be inappropriate because it can reset development data, so it is treated as a first-time setup step only.
12.4 Typical Student-to-Maintenance Demonstration
Stage	Action	Expected system behaviour
Step 1	Student signs in	The Student Portal opens and the student sees the allocated residence/room information.
Step 2	Inventory is completed	The student checks each room item, records condition and digitally signs/submits the inventory.
Step 3	Residence Staff review	Residence Staff sees the signed inventory and reviews the faults.
Step 4	Fault is forwarded	Residence Staff forwards the fault. The system creates an assignment, history and notifications.
Step 5	Maintenance accepts	Maintenance Staff opens the job queue and accepts responsibility for the job.
Step 6	Visit is scheduled	A future date/time and estimated duration are stored in MaintenanceVisits.
Step 7	Work starts	The job moves to in_progress and the student receives an update.
Step 8	Work completes	Maintenance enters a resolution note and completes the job.
Step 9	Traceability	The system retains the maintenance status history and notification record.
13. SECURITY IMPLEMENTATION
Security was treated as part of the design rather than only a final add-on. The system stores student and staff information and controls who may view or change residence records. The following controls were implemented in the application.
Control	How UFH-NestLink uses it
Password hashing	Passwords are hashed with bcrypt before storage. This is safer than plain-text password storage. OWASP recommends dedicated password-hashing algorithms such as bcrypt, scrypt or Argon2 rather than fast general hashes or plaintext (OWASP Foundation, 2026).
Role-based access control	Server middleware distinguishes Student, Residence Staff and Maintenance Staff. Access is enforced on backend routes, not only hidden in the interface.
Residence scoping	Residence Staff operations are restricted to the residence linked to the staff session, reducing cross-residence access.
Controlled staff creation	Normal public registration is student-oriented. Staff accounts are created through controlled paths rather than allowing a user to choose a privileged role freely.
Session-based authentication	After login, a server session represents the authenticated user. Logout destroys/clears the session cookie.
Input and state validation	The server checks allowed roles, allowed workflow states, future scheduling dates and required resolution notes before saving actions.
Environment separation	Secrets and environment configuration are kept outside source control through .env/.gitignore practices.
Database transactions	Related updates are grouped so failures are less likely to leave inconsistent maintenance records.
13.1 Security Items Recommended for Production
The development version runs locally over HTTP. Before institutional deployment, HTTPS/TLS should be configured at the web server or reverse proxy, secure cookie settings should be reviewed for the production domain, backups should be automated, database/file permissions should be hardened, and production SMTP credentials should be stored securely. These are deployment controls and are intentionally separated from features that are already implemented in the local assignment build.
14. TESTING AND EVALUATION
14.1 Testing Approach
Testing combined syntax checks, role-by-role manual testing, database inspection and full workflow testing. JavaScript files were checked with Node’s syntax checker before browser testing. The application was repeatedly restarted and tested after changes to ensure that frontend modifications did not break the backend.
Test	Scenario	Action	Expected result
T01	Student registration	Create a student account with eligible UFH email.	User saved with role student and active status.
T02	Student login	Enter correct email/password.	Student Portal opens; session is active.
T03	Wrong-role protection	Attempt staff-only API as student.	Server returns an access error.
T04	Inventory submission	Complete and sign inventory.	InventoryChecks and InventoryCheckItems are stored.
T05	Residence review	Residence Staff opens signed inventory.	Correct residence submission is visible.
T06	Forward fault	Forward an unforwarded maintenance fault.	Report becomes forwarded; assignment/history/notifications are created.
T07	Maintenance accept	Maintenance Staff accepts forwarded job.	Assignment records responsible maintenance user and accepted state.
T08	Schedule visit	Enter a future date/time.	MaintenanceVisits record is created and report becomes scheduled.
T09	Start work	Start a scheduled job.	Status becomes in_progress.
T10	Complete work	Enter resolution and complete.	Report/assignment become completed; history and notification update.
T11	Staff management	Create Maintenance Staff from Staff Management.	User is created in database with maintenance_staff role.
T12	Responsive UI	Resize browser / test narrow view.	Navigation and cards reorganise without losing functions.
T13	Git integrity	Commit and push changes.	git status reports working tree clean and branch up to date.
14.2 Evaluation Against the Project Aim
The system meets the main aim because the student inventory no longer depends on a paper form reaching the right office. The data is stored immediately in the system and can be reviewed by Residence Staff. Maintenance work is not only reported; it is tracked through explicit states. The strongest success of the project is therefore the traceability of the process from student submission to maintenance completion.
15. USE OF ARTIFICIAL INTELLIGENCE AS A LEARNING TOOL
Artificial intelligence was used during development as a learning and support tool, not as a substitute for understanding or as an automatic generator of the entire project. The team used AI assistance to explain unfamiliar JavaScript, Node.js, Express and SQL concepts in simpler language, suggest debugging steps, explain terminal errors, review code structure, and discuss user-interface improvements. The developers still had to create files, run commands, inspect errors, test the software, decide which suggestions matched the real system and verify that the final project worked.
15.1 Appropriate Uses of AI During the Project
•	Explaining programming concepts and syntax when the team was learning a language or library.
•	Helping interpret error messages from Node.js, Git, the browser and the database.
•	Suggesting safer or clearer ways to structure routes and role checks.
•	Providing examples that the team adapted to the existing project rather than copying an unrelated complete system.
•	Helping compare the intended workflow with the implemented workflow and identify inconsistencies.
•	Assisting with interface ideas and documentation wording after the team had already implemented and tested the system.
15.2 What AI Did Not Replace
AI did not replace the practical work required to build the application. The team still used VS Code, created the project structure, installed dependencies, maintained the database, started and stopped the server, tested accounts and roles, followed the inventory and maintenance flow, corrected integration problems, and pushed the final code to GitHub. Every AI suggestion had to be accepted, rejected or modified by the developers based on the behaviour of the real application. This distinction is important because software development requires understanding, testing and accountability, not only generated code.
16. CHALLENGES, LIMITATIONS AND FUTURE IMPROVEMENTS
16.1 Challenges Encountered
•	Keeping the frontend and backend role logic consistent after adding a Maintenance Staff portal.
•	Ensuring the database schema supported all three final roles and rebuilding the development database when the schema changed.
•	Connecting the final Residence Staff forwarding workflow to Maintenance without duplicating assignments.
•	Maintaining a clear status lifecycle so that jobs could not jump directly from forwarded to completed.
•	Improving the user interface without breaking already-working portal logic.
•	Managing Git commits and ensuring local environment/database files were not pushed to GitHub.
•	Recovering the development environment after unexpected shutdowns and confirming that the SQLite data and source code remained intact.
16.2 Current Limitations
•	The assignment version is demonstrated locally and is not yet deployed on a university production server.
•	Production HTTPS, institutional single sign-on and enterprise backup policies are outside the local prototype scope.
•	Email is designed to support SMTP but development mode may log email messages rather than sending live institutional mail.
•	SQLite is suitable for the prototype and moderate local use, but a larger production rollout may benefit from a managed server database.
•	Formal automated unit/integration test coverage can be expanded beyond current manual workflow and syntax testing.
16.3 Future Improvements
•	Deploy UFH-NestLink behind HTTPS on an institutional server.
•	Integrate with official UFH identity/student systems so room allocation and student verification can be synchronised.
•	Add administrative analytics for recurring faults, response time and residence trends.
•	Add file/photo evidence for maintenance faults with appropriate privacy controls.
•	Introduce automated testing and continuous integration on GitHub.
•	Add database backup/restore procedures and production monitoring.
•	Extend accessibility testing and keyboard/screen-reader support.
17. CONCLUSION
UFH-NestLink demonstrates how a small but important manual residence process can be redesigned as a connected digital workflow. The project began with the problem of paper inventory forms moving from students to a matron/residence representative and then to residence administration, where delays or lost documents could prevent issues from being resolved. The final application changes that process by storing signed inventory submissions immediately, making them visible to Residence Staff, and linking reported faults to a maintenance workflow.
Technically, the project combines a browser-based HTML/CSS/JavaScript frontend with a Node.js and Express backend, SQLite data storage, bcrypt password hashing, server sessions, role-based access control, notifications, email support and Git/GitHub version control. More importantly, the system provides traceability: the student submission, Residence Staff review, maintenance forwarding, acceptance, visit scheduling, work progress and completion can all exist in one database-backed process.
The project also shows the value of iterative development. The final system is not identical to the first proposal, because implementation revealed a simpler and more realistic role structure. The result is a focused digital inventory and maintenance system that directly addresses the original problem: reducing manual administration, reducing the chance of lost inventory records and helping students' residence issues reach the correct staff more quickly.
REFERENCES
Express.js. (2026). Express - Fast, unopinionated, minimalist web framework for Node.js. Available at: https://expressjs.com/ (Accessed: 23 September 2026).
Group 11. (2026). Inventory and Maintenance System: CSC224 Assignment. Department of Computational Science, University of Fort Hare. Unpublished course assignment.
Node.js. (2026). Node.js API Documentation. Available at: https://nodejs.org/api/documentation.html (Accessed: 23 September 2026).
Nodemailer. (2026). Nodemailer Documentation. Available at: https://nodemailer.com/ (Accessed: 23 September 2026).
OWASP Foundation. (2026). Password Storage Cheat Sheet. Available at: https://cheatsheetseries.owasp.org/cheatsheets/Password_Storage_Cheat_Sheet.html (Accessed: 23 September 2026).
Sommerville, I. (2016). Software Engineering. 10th ed. Pearson.
SQLite. (2026). About SQLite. Available at: https://www.sqlite.org/about.html (Accessed: 23 September 2026).
SQLite. (2026). SQLite Is Serverless. Available at: https://www.sqlite.org/serverless.html (Accessed: 23 September 2026).
Git. (2026). Git Documentation. Available at: https://git-scm.com/doc (Accessed: 23 September 2026).
MDN Web Docs. (2026). Web technology documentation for HTML, CSS and JavaScript. Available at: https://developer.mozilla.org/ (Accessed: 23 September 2026).
APPENDIX A: EXECUTION COMMANDS
The following commands summarise the normal development workflow. They are included for reproducibility and demonstration.
Purpose	Command
Open project folder	cd ~/Downloads/ufh-nestlink-final/ufh-nestlink-final
Install dependencies (first setup)	npm install
Initialise a new development database (first setup only)	npm run init-db
Start backend/application	npm start
Check frontend JavaScript syntax	node --check public/js/auth.js
Check Maintenance module syntax	node --check public/js/maintenance.js
Review Git changes	git status
Stage final source changes	git add .
Commit	git commit -m "Complete NestLink residence management system"
Push to GitHub	git push
Important: npm run init-db is a database-initialisation command and should not be run every time the server starts. Once a development database contains useful test records, normal startup uses npm start.
APPENDIX B: FINAL FUNCTIONAL CHECKLIST
☐ Homepage loads with UFH-NestLink branding and responsive navigation.
☐ Login modal and student registration modal open correctly.
☐ Student account can authenticate and reach Student Portal.
☐ Residence Staff account can authenticate and reach its residence dashboard.
☐ Maintenance Staff account can authenticate and reach Maintenance Department Portal.
☐ Student room allocation is visible only where appropriate.
☐ Digital inventory can be completed, signed and submitted.
☐ Residence Staff can review the signed inventory.
☐ Residence Staff can forward faults to Maintenance.
☐ Maintenance Staff can accept the job.
☐ Maintenance Staff can schedule a future visit.
☐ Maintenance Staff can start work.
☐ Maintenance Staff can complete work with a resolution note.
☐ Notifications/status history reflect workflow changes.
☐ Staff Management can create and manage staff accounts.
☐ Browser console is checked for red errors during final demonstration.
☐ GitHub contains the latest tracked source code while .env, node_modules and live SQLite database files remain excluded.
