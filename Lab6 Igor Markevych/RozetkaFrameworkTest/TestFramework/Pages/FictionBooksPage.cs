using OpenQA.Selenium;
using OpenQA.Selenium.Support.PageObjects;

namespace TestFramework.Pages
{
    public class FictionBooksPage
    {
        private IWebDriver _driver;

        public FictionBooksPage(IWebDriver driver)
        {
            _driver = driver;
            PageFactory.InitElements(driver, this);
        }

        [FindsBy(How = How.Id, Using = "price[min]")]
        public IWebElement MinimumPrice;

        [FindsBy(How = How.Id, Using = "price[max]")]
        public IWebElement MaximumPrice;

        [FindsBy(How = How.XPath, Using = "//*[@id='catalog_goods_block']/div/div[1]")]
        public IWebElement FirstElement;

        [FindsBy(How = How.Id, Using = "submitprice")]
        public IWebElement FilterByPrice;

        [FindsBy(How = How.Id, Using = "price_label")]
        public IWebElement Price;

        public FictionBooksPage SetMinimumPrice(int? price)
        {
            if (price == null) return this;
            MinimumPrice.SendKeys("a");
            for (int i = 0; i < 5; i++)
                MinimumPrice.SendKeys(Keys.Backspace);
            MinimumPrice.SendKeys(price.ToString());
            return this;
        }

        public FictionBooksPage SetMaximumPrice(int? price)
        {
            if (price == null) return this;
            MaximumPrice.SendKeys("a");
            for (int i = 0; i < 12; i++)
                MaximumPrice.SendKeys(Keys.Backspace);
            MaximumPrice.SendKeys(price.ToString());
            return this;
        }

        
        public FictionBooksPage SubmitPriceFilter()
        {
            FilterByPrice.SendKeys(Keys.Enter);
            return this;
        }

        public int? GetMinPrice()
        {
            var stringValue = MinimumPrice.GetAttribute("value");
            if (stringValue == null | stringValue == "")
                return null;
            else
            {
                int.TryParse(stringValue, out int result);
                return result;
            }
        }

        public int? GetMaxPrice()
        {
            var stringValue = MaximumPrice.GetAttribute("value");
            if (stringValue == null | stringValue == "")
                return null;
            else
            {
                int.TryParse(stringValue, out int result);
                return result;
            }
        }

        public int? GetPrice()
        {
            var stringValue = Price.Text;
            if (stringValue == null | stringValue == "")
                return null;
            else
            {
                int.TryParse(stringValue, out int result);
                return result;
            }
        }
    }
}
