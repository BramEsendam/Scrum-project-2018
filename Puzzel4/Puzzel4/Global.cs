﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Puzzel4
{
    internal static class Global
    {
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
    }
}
