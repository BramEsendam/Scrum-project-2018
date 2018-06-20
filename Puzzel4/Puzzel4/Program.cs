using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Puzzel4;
using Puzzel4.Data;

namespace Puzzel4
{
    public class Program
    {

        private static void Main(string[] args)
            => StartAsync().GetAwaiter().GetResult();


        private static async Task StartAsync()
        {
            Console.ForegroundColor = ConsoleColor.Blue;
            //starting game 
            Global.SartGame();
            Console.WriteLine($"Welcome {Global.Game.Name}, Please put the letters in the correct order to create a word to get the secret code.\r\nNote: the theme is space.\r\n");
            /*
            //looping trough all words
            for (var i = 0; i < Global.Words.Length; i++)
            {
                //writing scrambled word to console
                Console.WriteLine($"Word {i + 1}: {Global.RandomizeChars(Global.Words[i])}");
                //checking if input word is the correct word. If its not the correct word write That's incorrect to the console
                while (!Global.CheckWordInput(i, Console.ReadLine())) Console.WriteLine("That's incorrect!");
                Console.WriteLine("That's correct!\r\n");
            }
            Console.Clear();
            Console.WriteLine("Pls order the planet from largest to the smallest.");
            Console.WriteLine("venus, uranus, neptune, mercury, mars, pluto, jupiter, saturn, earth");
            for (var i = 0; i < Global.Words.Length; i++)
            {
                Console.WriteLine($"{i + 1}. = ...");
                //checking if the input is correct
                while (Global.CheckArrayInput(i, Console.ReadLine())) Console.WriteLine("That's incorrect!");
                Console.WriteLine("That's correct!\r\n");
            }*/

            
            //writing the number to console
            Global.Game.TimeCompleted = DateTime.Now;
            Global.Game.Score = (int) Math.Round(DateTime.Now.Subtract(Global.Game.TimeCompleted).TotalSeconds * 0.43);
            GameHandler.SaveAccounts();
            Console.WriteLine($"You completed the game in: {Math.Round(DateTime.Now.Subtract(Global.Game.TimeCompleted).TotalSeconds, 2)} seconds." +
                              $"Your score is: {Global.Game.Score}");
            Console.BackgroundColor = ConsoleColor.Green;
            Console.WriteLine(365);
            //delaying the task so it doesn't close
            await Task.Delay(-1);
        }
    }
}
