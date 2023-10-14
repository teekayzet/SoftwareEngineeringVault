class UniversityProjectsDiary
    {
        private List<Contact> contacts;
        private List<Meeting> meetings;

        public UniversityProjectsDiary()
        {
            contacts = new List<Contact>();
            meetings = new List<Meeting>();
        }

        public void ShowContactDetailsMenu()
        {
            while (true)
            {
                Console.WriteLine("\nContact Details Menu");
                Console.WriteLine("1. Add new contact");
                Console.WriteLine("2. Delete contact");
                Console.WriteLine("3. Edit contact");
                Console.WriteLine("4. Search contact");
                Console.WriteLine("5. Go back");
                Console.Write("Enter your choice: ");

                string choice = Console.ReadLine();

                switch (choice)
                {
                    case "1":
                        AddContact();
                        break;

                    case "2":
                        DeleteContact();
                        break;

                    case "3":
                        EditContact();
                        break;

                    case "4":
                        SearchContact();
                        break;

                    case "5":
                        Console.WriteLine("Going back to the main menu...\n");
                        return;

                    default:
                        Console.WriteLine("Invalid choice. Please try again.\n");
                        break;
                }
            }
        }

        public void ShowMeetingsAppointmentsMenu()
        {
            while (true)
            {
                Console.WriteLine("\nMeetings/Appointments Menu");
                Console.WriteLine("1. Add new meeting/appointment");
                Console.WriteLine("2. Delete meeting/appointment");
                Console.WriteLine("3. Edit meeting/appointment");
                Console.WriteLine("4. Search meeting/appointment");
                Console.WriteLine("5. Go back");
                Console.Write("Enter your choice: ");

                string choice = Console.ReadLine();

                switch (choice)
                {
                    case "1":
                        AddMeeting();
                        break;

                    case "2":
                        DeleteMeeting();
                        break;case "3":
                        EditMeeting();
                        break;

                    case "4":
                        SearchMeeting();
                        break;

                    case "5":
                        Console.WriteLine("Going back to the main menu...\n");
                        return;

                    default:
                        Console.WriteLine("Invalid choice. Please try again.\n");
                        break;
                }
            }
        }

        private void AddContact()
        {
            Console.WriteLine("\nAdding new contact");
            Console.Write("Enter name: ");
            string name = Console.ReadLine();
            Console.Write("Enter address: ");
            string address = Console.ReadLine();
            Console.Write("Enter phone number: ");
            string phone = Console.ReadLine();
            Console.Write("Enter email address: ");
            string email = Console.ReadLine();

            Contact newContact = new Contact(name, address, phone, email);
            contacts.Add(newContact);

            Console.WriteLine("Contact added successfully.\n");
        }

        private void DeleteContact()
        {
            Console.WriteLine("\nDeleting contact");
            Console.Write("Enter the name of the contact to delete: ");
            string name = Console.ReadLine();

            Contact contactToDelete = contacts.Find(c => c.Name == name);
            if (contactToDelete != null)
            {
                contacts.Remove(contactToDelete);
                Console.WriteLine("Contact deleted successfully.\n");
            }
            else
            {
                Console.WriteLine("Contact not found.\n");
            }
        }

        private void EditContact()
        {
            Console.WriteLine("\nEditing contact");
            Console.Write("Enter the name of the contact to edit: ");
            string name = Console.ReadLine();

            Contact contactToEdit = contacts.Find(c => c.Name == name);
            if (contactToEdit != null)
            {
                Console.Write("Enter new address: ");
                contactToEdit.Address = Console.ReadLine();
                Console.Write("Enter new phone number: ");
                contactToEdit.Phone = Console.ReadLine();
                Console.Write("Enter new email address: ");
                contactToEdit.Email = Console.ReadLine();

                Console.WriteLine("Contact edited successfully.\n");
            }
            else
            {
                Console.WriteLine("Contact not found.\n");
            }
        }

        private void SearchContact()
        {
            Console.WriteLine("\nSearching contact");
            Console.Write("Enter the name of the contact to search: ");
            string name = Console.ReadLine();

            Contact foundContact = contacts.Find(c => c.Name == name);
            if (foundContact != null)
            {
                Console.WriteLine("Contact found:");
                Console.WriteLine(foundContact);
            }
            else
            {
                Console.WriteLine("Contact not found.\n");
            }
        }

        private void AddMeeting()
        {
            Console.WriteLine("\nAdding new meeting/appointment");
            Console.Write("Enter date (YYYY-MM-DD): ");
            string dateInput = Console.ReadLine();
            Console.Write("Enter time: ");
            string time = Console.ReadLine();
            Console.Write("Enter location: ");
            string location = Console.ReadLine();

            // Validate and parse the date
            DateTime meetingDate;
            if (DateTime.TryParse(dateInput, out meetingDate))
            {
                Meeting newMeeting = new Meeting(meetingDate, time, location);
                meetings.Add(newMeeting);

                Console.WriteLine("Meeting/appointment added successfully.\n");
            }
            else
            {
                Console.WriteLine("Invalid date format. Meeting/appointment not added.\n");
            }
        }

        private void DeleteMeeting()
        {
            Console.WriteLine("\nDeleting meeting/appointment");
            Console.Write("Enter the date of the meeting/appointment to delete (YYYY-MM-DD): ");
            string dateInput = Console.ReadLine();

            // Validate and parse the date
            DateTime meetingDate;
            if (DateTime.TryParse(dateInput, out meetingDate))
            {
                Meeting meetingToDelete = meetings.Find(m => m.Date == meetingDate);
                if (meetingToDelete != null)
                {
                    meetings.Remove(meetingToDelete);
                    Console.WriteLine("Meeting/appointment deleted successfully.\n");
                }
                else
                {
                    Console.WriteLine("Meeting/appointment not found.\n");
                }
            }
            else
            {
                Console.WriteLine("Invalid date format. Meeting/appointment not deleted.\n");
            }
        }

        private void EditMeeting()
        {
            Console.WriteLine("\nEditing meeting/appointment");
            Console.Write("Enter the date of the meeting/appointment to edit (YYYY-MM-DD): ");
            string dateInput = Console.ReadLine();

            // Validate and parse the date
            DateTime meetingDate;
            if (DateTime.TryParse(dateInput, out meetingDate))
            {
                Meeting meetingToEdit = meetings.Find(m => m.Date == meetingDate);
                if (meetingToEdit != null)
                {
                    Console.Write("Enter new time: ");
                    meetingToEdit.Time = Console.ReadLine();
                    Console.Write("Enter new location: ");
                    meetingToEdit.Location = Console.ReadLine();

                    Console.WriteLine("Meeting/appointment edited successfully.\n");
                }
                else
                {
                    Console.WriteLine("Meeting/appointment not found.\n");
                }
            }
            else
            {
                Console.WriteLine("Invalid date format. Meeting/appointment not edited.\n");
            }
        }

        private void SearchMeeting()
        {
            Console.WriteLine("\nSearching meeting/appointment");
            Console.Write("Enter the date of the meeting/appointment to search (YYYY-MM-DD): ");
            string dateInput = Console.ReadLine();

            // Validate and parse the date
            DateTime meetingDate;
            if (DateTime.TryParse(dateInput, out meetingDate))
            {
                Meeting foundMeeting = meetings.Find(m => m.Date == meetingDate);
                if (foundMeeting != null)
                {
                    Console.WriteLine("Meeting/appointment found:");
                    Console.WriteLine(foundMeeting);
                }
                else
                {
                    Console.WriteLine("Meeting/appointment not found.\n");
                }
            }
            else
            {
                Console.WriteLine("Invalid date format. Meeting/appointment not found.\n");
            }
        }
    }
