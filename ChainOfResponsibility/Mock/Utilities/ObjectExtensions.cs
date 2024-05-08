namespace ChainOfResponsibility.Mock.Utilities
{
    public static class ObjectExtensions
    {
        public static string AddMessage(this object @this, string message)
        {
            var msg = @this.GetType().Name;
            return string.IsNullOrWhiteSpace(message) 
                ? msg 
                : message + "\n" + msg;
        }
    }
}
