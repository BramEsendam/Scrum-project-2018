using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Puzzel4
{
    public class Program
    {
        private static void Main(string[] args)
            => new Program().StartAsync().GetAwaiter().GetResult();


        private async Task StartAsync()
        {
            Console.ForegroundColor = ConsoleColor.Blue;
            Console.WriteLine("Pls put the letters in the correct order to create 2 words.\r\nNote: the theme is space.\r\n");

            Console.WriteLine("Word 1: kmily ywa");
            //checking if input word is the correct word. If its not the correct word write That's incorrect to the console
            while (!Global.CheckInput(1, Console.ReadLine())) Console.WriteLine("That's incorrect!");
            Console.WriteLine("That's correct!\r\n");

            Console.WriteLine("Word 2: lwhiproo ygaaxl");
            //checking if input word is the correct word. If its not the correct word write That's incorrect to the console
            while (!Global.CheckInput(2, Console.ReadLine())) Console.WriteLine("That's incorrect!");
            Console.WriteLine("That's correct!\r\n");

            Console.WriteLine("Word 3: oameddrna laayxg");
            //checking if input word is the correct word. If its not the correct word write That's incorrect to the console
            while (!Global.CheckInput(3, Console.ReadLine())) Console.WriteLine("That's incorrect!");
            Console.WriteLine("That's correct!\r\n");

            //writing the number to console
            Console.BackgroundColor = ConsoleColor.Green;
            Console.WriteLine(365);
            await Task.Delay(-1);
        }
    }
}
