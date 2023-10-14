using System;
using System.Collections.Generic;

namespace UniversityProjectsDiary
{
class Program
{
    static void Main(string[] args)
    {
        UniversityProjectsDiary.UniversityProjectsDiary diary = new UniversityProjectsDiary.UniversityProjectsDiary();

        // Display main menu and handle user input
        while (true)
        {
            Console.WriteLine("University Projects Diary");
            Console.WriteLine("1. Contact Details");
            Console.WriteLine("2. Meetings/Appointments");
            Console.WriteLine("3. Exit");
            Console.Write("Enter your choice: ");

            string choice = Console.ReadLine();

            switch (choice)
            {
                case "1":
                    UniversityProjectsDiary.ShowContactDetailsMenu();
                    break;

                case "2":
                    UniversityProjectsDiary.ShowMeetingsAppointmentsMenu();
                    break;

                case "3":
                    Console.WriteLine("Exiting the program...");
                    return;

                default:
                    Console.WriteLine("Invalid choice. Please try again.\n");
                    break;
            }
        }
    }
}
}

