import javax.swing.text.PlainDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

public class TextFieldLimit extends PlainDocument
{
	private int max;
	
	public TextFieldLimit(int max) 
	{
		super();
		this.max=max;
	}
	
	public void insertString(int offset,String str, AttributeSet attribute)throws BadLocationException
	{
	   {
		  if (str==null)
			return ;
		
		  if ((getLength()+str.length())<=max)
		  {
			super.insertString(offset,str,attribute);
		  }
	   }
	}
}
