class Contact
    {
        public string Name { get; set; }
        public string Address { get; set; }
        public string Phone { get; set; }
        public string Email { get; set; }

        public Contact(string name, string address, string phone, string email)
        {
            Name =name;
            Address = address;
            Phone = phone;
            Email = email;
        }

        public override string ToString()
        {
            return $"Name: {Name}\nAddress: {Address}\nPhone: {Phone}\nEmail: {Email}\n";
        }
    }
