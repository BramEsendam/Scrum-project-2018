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
        private static List<Game> Games;

        private const string GameFile = "Data/Games.json";

        public static void SaveAccounts()
        {
            Datastorage.SaveGames(Games, GameFile);
        }

        public static Game GetAccount(string name)
        {
            if (Datastorage.SaveExists(GameFile))
            {
                Games = Datastorage.LoadGames(GameFile).ToList();
            }
            else
            {
                Directory.CreateDirectory("Data/");
                Games = new List<Game>();
                SaveAccounts();
            }
            return GetOrCreateAccount(name);
        }

        private static Game GetOrCreateAccount(string name)
        {
            var result = from a in Games
                         where a.Name == name
                         select a;

            var account = result.FirstOrDefault() ?? CreateServerAccount(name);
            return account;
        }

        private static Game CreateServerAccount(string name)
        {
            var newGame = new Game()
            {
                Name = name,
                Score = 0,
                TimeStarted = DateTime.Now
            };
            Games.Add(newGame);
            SaveAccounts();
            return newGame;
        }
    }
}