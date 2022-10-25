using System;
namespace rest_api.Models
{
    public class Person
    {
        int id;
        String name;
        int age;

        public String Name
        {
            get { return name; }
            set { name = value; }
        }

        public int Age
        {
            get { return age; }
            set { age = value; }
        }

        public int Id
        {
            get { return id; }
            set { id = value; }
        }
    }
}
