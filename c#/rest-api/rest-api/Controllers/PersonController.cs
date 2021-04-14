using System.Collections.Generic;
using System.Linq;
using Microsoft.AspNetCore.Mvc;
using rest_api.Models;
using restapi.Models;

namespace rest_api.Controllers
{
    [Route("api/person")]
    [ApiController]
    public class PersonController : ControllerBase
    {
        private readonly PersonContext personContext;

        public PersonController(PersonContext personContext)
        {
            this.personContext = personContext;
        }

        [HttpGet]
        public ActionResult<IEnumerable<Person>> Get()
        {
            return personContext.Persons.ToList();
        }

        [HttpGet("{id}")]
        public ActionResult<Person> Get(int id)
        {
            Person person = personContext.Persons.Find(id);
            if (person == null)
            {
                return NotFound();
            }
            return person;
        }

        [HttpPost]
        public void Post([FromBody] Person person)
        {
            personContext.Persons.Add(person);
            personContext.SaveChanges();
        }

        [HttpPut]
        public void Put([FromBody] Person person)
        {
            personContext.Persons.Update(person);
            personContext.SaveChanges();
        }

        [HttpDelete("{id}")]
        public void Delete(int id)
        {
            Person person = personContext.Persons.Find(id);
            if (person != null)
            {
                personContext.Persons.Remove(person);
            }
        }
    }
}
