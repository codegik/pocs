using System;
using Microsoft.EntityFrameworkCore;
using rest_api.Models;

namespace restapi.Models
{
    public class PersonContext : DbContext
    {
        public PersonContext(DbContextOptions<PersonContext> options) : base(options)
        {
        }

        public DbSet<Person> Persons { get; set; }
    }
}
