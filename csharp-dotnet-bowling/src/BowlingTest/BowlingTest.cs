namespace BowlingTest;

using NUnit.Framework;
using Bowling;

public class Tests
{
    private BowlingGame g;


    [SetUp]
    public void SetUp()
    {
        g = new BowlingGame();
    }

    private void rollMany(int n, int pins)
    {
        for (int i = 0; i < n; ++i)
        {
            g.Roll(pins);
        }
    }

    private void rollSpare()
    {
        g.Roll(5);
        g.Roll(5);
    }

    private void rollStrike()
    {
        g.Roll(10);
    }

    [Test]
    public void gutterGame()
    {
        rollMany(20, 0);
        Assert.AreEqual(0, g.Score());
    }

    [Test]
    public void allOnes()
    {
        rollMany(20, 1);
        Assert.AreEqual(20, g.Score());
    }

    [Test]
    public void oneSpare()
    {
        rollSpare();
        g.Roll(3);
        rollMany(17, 0);
        Assert.AreEqual(16, g.Score());
    }

    [Test]
    public void oneStrike()
    {
        rollStrike();
        g.Roll(3);
        g.Roll(4);
        rollMany(16, 0);
        Assert.AreEqual(24, g.Score());
    }

    [Test]
    public void perfectGame()
    {
        rollMany(12, 10);
        Assert.AreEqual(300, g.Score());
    }
}