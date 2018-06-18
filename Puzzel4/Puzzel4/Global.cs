using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Puzzel4
{
    internal static class Global
    {
        internal static string[] Words = {"Milky Way", "Whirlpool Galaxy", "Andromeda Galaxy" };

        internal static bool CheckInput(byte index, string input)
        {
            return Words[index - 1].ToLower().Equals(input.ToLower());
        }
    }
}
