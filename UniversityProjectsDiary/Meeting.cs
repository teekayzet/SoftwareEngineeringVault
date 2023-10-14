class Meeting
    {
        public DateTime Date { get; set; }
        public string Time { get; set; }
        public string Location { get; set; }

        public Meeting(DateTime date, string time, string location)
        {
            Date = date;
            Time = time;
            Location = location;
        }

        public override string ToString()
        {
            return $"Date: {Date.ToString("yyyy-MM-dd")}\nTime: {Time}\nLocation: {Location}\n";
        }
    }
