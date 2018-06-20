using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Puzzel4.Data
{
    public class Game
    {
        public string Name { get; set; }
        public DateTime TimeStarted { get; set; }
        public DateTime TimeCompleted  { get; set; }
        public int Score { get; set; }
    }
}
