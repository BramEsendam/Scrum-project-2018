using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Newtonsoft.Json;

namespace Puzzel4.Data
{
    public class Datastorage
    {
        private static readonly object Lock = new object();
        public static bool SaveExists(string filePath)
        {
            return File.Exists(filePath);
        }

        public static void SaveGames(IEnumerable<Game> games, string filePath)
        {
            lock (Lock)
            {
                var json = JsonConvert.SerializeObject(games, Formatting.Indented);
                File.WriteAllText(filePath, json);
            }
        }

        public static IEnumerable<Game> LoadGames(string filePath)
        {
            if (!File.Exists(filePath)) return null;
            var json = File.ReadAllText(filePath);
            return JsonConvert.DeserializeObject<List<Game>>(json);
        }
    }
}
