using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Puzzel4.Data;

namespace Puzzel4
{
    internal static class Global
    {
        internal static Game Game { get; set; }


        internal static string[] Words = {"jupiter", "saturn", "uranus", "neptune", "earth", "venus", "mars", "mercury", "pluto" };
        internal static Random Rnd = new Random();
        internal static bool CheckWordInput(int index, string input)
        {
            return Words[index].ToLower().Equals(input.ToLower());
        }

        internal static bool CheckArrayInput(int index, string input)
        {
            return !Words[index].ToLower().Equals(input.ToLower());
        }

        internal static string RandomizeChars(string word)
        {
            var chars = new char[word.Length];
            var index = 0;
            while (word.Length > 0)
            {
                var next = Rnd.Next(0, word.Length - 1);
                chars[index] = word[next];
                word = word.Substring(0, next) + word.Substring(next + 1);
                ++index;
            }
            return new string(chars);
        }

        internal static void SartGame()
        {
            Console.WriteLine("Please enter your name.");
            var name = Console.ReadLine();
            Console.WriteLine($"Is this your name: {name}\r\nY/N");
            while (Console.ReadKey().Key == ConsoleKey.N || name == null)
            {
                name = null;
                Console.WriteLine("\r\nPlease enter your name again.");
                name = Console.ReadLine();
                Console.WriteLine("Press enter to start.");
            }
            Console.WriteLine("Starting game...\r\n");
            Game = GameHandler.GetAccount(name);
            Game.TimeStarted = DateTime.Now;
            Game.Score = 0;
        }
    }
}