package com.j2ee.project.taglib;

import java.io.Writer;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PaginationTaglib extends SimpleTagSupport {
    private String uri;
    private int offset;
    public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}


	private int count;
    public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getSteps() {
		return steps;
	}

	public void setSteps(int steps) {
		this.steps = steps;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}


	private int max = 9;
    private int steps = 10;
    private String previous = "Previous";
    private String next = "Next";

    private Writer getWriter() {
        JspWriter out = getJspContext().getOut();
        return out;
    }

    @Override
    public void doTag() throws JspException {
        Writer out = getWriter();

        try {
            out.write("<div class=\"ui pagination menu\">");
            
            if(offset<steps)
                out.write(constructLink(1, previous, "disabled", true));
            else
                out.write(constructLink(offset-steps, previous, null, false));
            
            for(int itr=0;itr<count;itr+=steps) {
                if(offset==itr)
                    out.write(constructLink((itr/10+1)-1 *steps, String.valueOf(itr/10+1), "active", true));
                else
                    out.write(constructLink(itr/10*steps, String.valueOf(itr/10+1), null , false));
            }

            if(offset+steps>=count)
                out.write(constructLink(offset+steps, next, "disabled", true));
            else
                out.write(constructLink(offset+steps, next, null , false));
            
            out.write("</div>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in Paginator tag", ex);
        }
    }


    private String constructLink(int page, String text, String className, boolean disabled) {
        StringBuilder link = new StringBuilder("<a");
        if (className == "active") {
            link.append(" class=\"");
            link.append(className+" item");
            link.append("\"");
        }
        else{
        	link.append(" class=\"");
            link.append("item");
            link.append("\"");
        }
        if(disabled)
            link.append("href=\"#\">"+text+"</a>");
        else
            link.append("href=\""+uri+"?offset="+page + "\">"+text+"</a>");
        return link.toString();
    }
}