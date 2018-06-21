using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.ConsoleKey;

namespace SpaceQuiz
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.ForegroundColor = ConsoleColor.Blue;
           // Console.WriteLine("Welcome in the space quiz \n]Answer with capitol pls \n \nPress enter to start");

            Quiz();
            Console.WriteLine("\r\nPress R to restart.");
            while (true)
            {
                while (Console.ReadKey().Key == R)
                {
                    Console.Clear();
                    Quiz();
                }
            }
        }

        public static void Quiz()
        {
            var score = 0;
            Console.WriteLine("How many planets are in the Solar System?");
            var entry1 = Console.ReadLine();

            if (entry1 == "8")
            {
                score += 1;
                Console.WriteLine("Correct!!!  \n");
            }
            else
            {
                Console.WriteLine("WRONG  \n");
            }

            Console.WriteLine("What is the smallest planet in our solar system?");
            var entry2 = Console.ReadLine();

            if (entry2 != null && string.Equals(entry2, "Mercury", StringComparison.CurrentCultureIgnoreCase))
            {
                score += 1;
                Console.WriteLine("Correct!!!  \n");
            }
            else
            {
                Console.WriteLine("WRONG  \n");
            }

            Console.WriteLine("What has a gravitational pull so strong that even light cannot escape it?");
            var entry3 = Console.ReadLine();

            if (string.Equals(entry3, "Black Hole", StringComparison.CurrentCultureIgnoreCase))
            {
                score += 1;
                Console.WriteLine("Correct!!!  \n");
            }
            else
            {
                Console.WriteLine("WRONG  \n");
            }

            Console.WriteLine("Who was the first person to walk on the moon?");
            var entry4 = Console.ReadLine();

            if (entry4 != null && string.Equals(entry4, "Neil Armstrong", StringComparison.CurrentCultureIgnoreCase))
            {
                score += 1;
                Console.WriteLine("Correct!!!  \n");
            }
            else
            {
                Console.WriteLine("WRONG  \n");
            }

            Console.WriteLine("What is the hottest planet in our solar system?");
            var entry5 = Console.ReadLine();

            if (entry5 != null && string.Equals(entry5, "Venus", StringComparison.CurrentCultureIgnoreCase))
            {
                score += 1;
                Console.WriteLine("Correct!!!  \n");
            }
            else
            {
                Console.WriteLine("WRONG  \n");
            }

            if (score == 5)
            {
                Console.WriteLine($"Nice! you have won pls continue \nyour code is: ");
                Console.WriteLine("13");
                Console.BackgroundColor = ConsoleColor.Green;
                Console.BackgroundColor = ConsoleColor.Black;
            }
            else
            {
                Console.WriteLine("pls start again your score was " + score);
            }
        }
    }
}

