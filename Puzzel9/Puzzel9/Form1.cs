using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Drawing.Drawing2D;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Puzzel9
{
    public partial class Form1 : Form
    {

        private Point emptyPoint;
        private readonly Image toBeResize;
        private const int Temp = 21;
        public Form1()
        {
            InitializeComponent();

            toBeResize = pictureBox1.Image;
            pictureBox1.BackgroundImage = toBeResize;
            emptyPoint.X = 330;
            emptyPoint.Y = 330;
            AddImages(ReturnImagesList(Resize(toBeResize), 110, 110));
        }

        private void panel1_Paint(object sender, PaintEventArgs e)
        {

        }

        private void Buttons_Click(object sender, EventArgs e)
        {
            //moving the button
            MoveButton((Button)sender);
            //checking if all the rows are correct
            if (button7.Location.Y != 0 || button7.Location.X != 0 || button15.Location.Y != 0 ||
                button15.Location.X != 110 || button1.Location.Y != 0 || button1.Location.X != 220 ||
                button14.Location.Y != 0 || button14.Location.X != 330) return;
            Console.WriteLine("First row correct");
            if (button2.Location.Y != 110 || button2.Location.X != 0 || button13.Location.Y != 110 ||
                button13.Location.X != 110 || button3.Location.Y != 110 || button3.Location.X != 220 ||
                button12.Location.Y != 110 || button12.Location.X != 330) return;
            Console.WriteLine("Second row correct");
            if (button4.Location.Y != 220 || button4.Location.X != 0 || button11.Location.Y != 220 ||
                button11.Location.X != 110 || button5.Location.Y != 220 || button5.Location.X != 220 ||
                button10.Location.Y != 220 || button10.Location.X != 330) return;
            Console.WriteLine("third row correct");
            if (button6.Location.Y != 330 || button6.Location.X != 0 || button9.Location.Y != 330 ||
                button9.Location.X != 110 || button8.Location.Y != 330 || button8.Location.X != 220) return;
            Console.WriteLine("fourth row correct");
            MessageBox.Show($"{Temp}");
        }

        private void MoveButton(Control button)
        {
            Console.WriteLine(button.Name);
            Console.WriteLine($"old Y:{button.Location.Y} X:{button.Location.X}");

            var x = emptyPoint.X - button.Location.X;
            var px = x < 0 ? -x : x;

            var y = emptyPoint.Y - button.Location.Y;
            var py = y < 0 ? -y : y;
            if (button.Location.Y.Equals(emptyPoint.Y) && px.Equals(button.Size.Width))
            {
                button.Location = new Point(button.Location.X + x, button.Location.Y);
                emptyPoint.X -= x;
            }
            if (!button.Location.X.Equals(emptyPoint.X) || !py.Equals(button.Size.Width)) return;
            button.Location = new Point(button.Location.X, button.Location.Y + y);
            emptyPoint.Y -= y;
            Console.WriteLine($"new Y:{button.Location.Y} X:{button.Location.X}");
        }

        public void AddImages(ArrayList pieces)
        {
            var x = 0;
            var c = new[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
            foreach (Button b in panel1.Controls)
            {
                if (x >= c.Length) continue;
                Console.WriteLine(c[x]);
                b.Image = (Image)pieces[c[x]];
                x++;
            }
        }

        public ArrayList ReturnImagesList(Bitmap toBeCropped, int x, int y)
        {
            var imgPieces = new ArrayList();
            var moveright = 0;
            var movedown = 0;

            for (var k = 0; k < 16; k++)
            {
                var piece = new Bitmap(x, y);

                for (var i = 0; i < x; i++)
                    for (var j = 0; j < y; j++) piece.SetPixel(i, j, toBeCropped.GetPixel(i + moveright, j + movedown));
                imgPieces.Add(piece);

                moveright += 110;

                if (moveright == 440) { moveright = 0; movedown += 110; }
                if (movedown == 440) { break; }
            }

            return imgPieces;
        }

        private new static Bitmap Resize(Image img)
        {
            var bitmap = new Bitmap(440, 440);
            var graphic = Graphics.FromImage((Image)bitmap);
            graphic.InterpolationMode = InterpolationMode.HighQualityBicubic;
            graphic.DrawImage(img, 0, 0, 440, 440);
            graphic.Dispose();
            return bitmap;
        }
    }
}
