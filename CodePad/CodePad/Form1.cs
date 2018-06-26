using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CodePad
{
    public partial class Form1 : Form
    {
        public bool[] Puzzels { get; set; }
        private byte puzzel = 2;
        public Form1()
        {
            InitializeComponent();
            Puzzels = new bool[8];
            for (var i = 0; i < 8; i++)
            {
                Puzzels[i] = false;
            }
        }

        private void SetText(string text)
        {
            txtResult.Text += text;
        }

        private void btn1_Click(object sender, EventArgs e)
        {
            SetText("1");
        }

        private void btn2_Click(object sender, EventArgs e)
        {
            SetText("2");
        }

        private void btn3_Click(object sender, EventArgs e)
        {
            SetText("3");
        }

        private void btn4_Click(object sender, EventArgs e)
        {
            SetText("4");
        }

        private void btn5_Click(object sender, EventArgs e)
        {
            SetText("5");
        }

        private void btn6_Click(object sender, EventArgs e)
        {
            SetText("6");
        }

        private void btn7_Click(object sender, EventArgs e)
        {
            SetText("7");
        }

        private void btn8_Click(object sender, EventArgs e)
        {
            SetText("8");
        }

        private void btn9_Click(object sender, EventArgs e)
        {
            SetText("9");
        }

        private void btn0_Click(object sender, EventArgs e)
        {
            SetText("0");
        }

        private void btnClear_Click(object sender, EventArgs e)
        {
            txtResult.Text = "";
        }

        private void btnEnter_Click(object sender, EventArgs e)
        {
            try
            {
                if (puzzel > 9) lblText.Text = $"Done!!";
                CheckNumber(int.Parse(txtResult.Text));
            }
            catch (Exception exception)
            {
                Console.WriteLine(exception);
            }
        }

        private void CheckNumber(int number)
        {
            int[] numbers = {0, 0, 69, 56, 365, 71, 13, 16, 34, 21};
            if (numbers[puzzel] != number) return;
            puzzel++;
            txtResult.Text = "";
            lblText.Text = $"Enter the number from puzzel {puzzel}";
            if(puzzel > 9) lblText.Text = $"Done!!";
        }

        private void txtResult_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.KeyCode != Keys.Enter) return;
            try
            {
                if (puzzel > 9) lblText.Text = $"Done!!";
                CheckNumber(int.Parse(txtResult.Text));
            }
            catch (Exception exception)
            {
                Console.WriteLine(exception);
            }
        }
    }
}
