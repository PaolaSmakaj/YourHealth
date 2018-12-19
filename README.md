# YourHealth
The software that the group intends to develop aims to be a management system that will help the patient to book his medical examinations, in a hypothetical clinic, directly checking the availability of the outpatient clinics and the related doctors. Therefore, there will be an admin, a patient and a doctor side.

The following are all the requirements that the application must meet:
- At the start it will be possible to log in.
- The user can request and cancel any type of booking, according to his needs.
- The user will have the possibility to scroll through a list of all available services (the system will therefore take into account the accessibility of clinics and machinery).
- Doctors will see their appointment list updated after each booking.
- The admin can add and remove items from the various lists.
- User-friendly interface.

Optional features:
- The software will take care to occupy only the offices suitable for that specific visit. (eg an outpatient that can not be darkened will never be up to an ultrasound).
- View of the booking history.
- Choice of interface language.

Challenge:
- The entire application will rely on a database.
- The system will be scalable, so it can be used for any hospital management activity.

Subdivision of the work:
- Model: Lorenzo Martini
- View: Paola Smakaj
- Controller: Lorenzo Martini (interrogation of the db) Paola Smakaj (reservation management)
