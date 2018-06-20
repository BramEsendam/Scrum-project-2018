using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Puzzel4.Data
{
    public class GameHandler
    {
        private static List<Game> _games;

        private const string GameFile = "Data/Games.json";

        public static void SaveAccounts()
        {
            Datastorage.SaveGames(_games, GameFile);
        }

        public static Game GetAccount(string name)
        {
            if (Datastorage.SaveExists(GameFile))
            {
                _games = Datastorage.LoadGames(GameFile).ToList();
            }
            else
            {
                Directory.CreateDirectory("Data/");
                _games = new List<Game>();
                SaveAccounts();
            }
            return GetOrCreateAccount(name);
        }

        private static Game GetOrCreateAccount(string name)
        {
            var result = from a in _games
                         where a.Name == name
                         select a;

            var account = result.FirstOrDefault() ?? CreateServerAccount(name);
            return account;
        }

        private static Game CreateServerAccount(string name)
        {
            var newGame = new Game
            {
                Name = name,
                Score = 0,
                TimeStarted = DateTime.Now
            };
            _games.Add(newGame);
            SaveAccounts();
            return newGame;
        }
    }
}