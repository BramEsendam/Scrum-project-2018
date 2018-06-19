using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SpaceQuiz
{
    class Program
    {
        static void Main(string[] args)
        {
            int score = 0;

            Console.ForegroundColor = ConsoleColor.Blue;
            Console.WriteLine("Welcome in the space quiz \nAhnswer with capitol pls \n \n ");

            Console.WriteLine("How many planets are in the Solar System?");
            var entry1 = Console.ReadLine();

            if (entry1 == "8")
            {
                score += 1;
                Console.WriteLine("Correct!!!");
            }
            else
            {
                Console.WriteLine("WRONG");
            }

            Console.WriteLine("What is the smallest planet in our solar system?");
            var entry2 = Console.ReadLine();

            if (entry2 == "Mercury")
            {
                score += 1;
                Console.WriteLine("Correct!!!");
            }
            else
            {
                Console.WriteLine("WRONG");
            }

            Console.WriteLine("What has a gravitational pull so strong that even light cannot escape it?");
            var entry3 = Console.ReadLine();

            if (entry3 == "Black Hole")
            {
                score += 1;
                Console.WriteLine("Correct!!!");
            }
            else
            {
                Console.WriteLine("WRONG");
            }

            Console.WriteLine("Who was the first person to walk on the moon?");
            var entry4 = Console.ReadLine();

            if (entry4 == "Neil Armstrong")
            {
                score += 1;
                Console.WriteLine("Correct!!!");
            }
            else
            {
                Console.WriteLine("WRONG");
            }

            Console.WriteLine("What is the hottest planet in our solar system?");
            var entry5 = Console.ReadLine();

            if (entry5 == "Venus")
            {
                score += 1;
                Console.WriteLine("Correct!!!");
            }
            else
            {
                Console.WriteLine("WRONG");
            }

            if (score == 5)
            {
                Console.WriteLine("Nice! you have won pls continue \nyour code is 13");
            }
            else
            {
                Console.WriteLine("pls start again your score was " + score);
            }
            Console.ReadLine();
        }
    }
}

