package com.neumino.pdftostandardhtml;

public class Convert {
	public static void main(String[] args) {
		if (args.length != 4) {
			System.out.println("Invalid arguments");
			System.out.println("Use: java -jar PDF-to-standard-HTML.jar path/to/pdf/file.pdf path/to/output/file.html type zoom");
			System.out.println("type is an int:");
			System.out.println("0 for the simplest method");
			System.out.println("1 to group letters by word");
			System.out.println("2 to group letters by line");
			System.out.println("3 to group letters by line using a cache");
			System.exit(1);
		}
		
		
		String pdfFileName = args[0];

		String outputFileName =  args[1];
		int type =  Integer.parseInt(args[2]);
		float zoom = Float.parseFloat(args[3]);

		try {
			HtmlFile htmlFile = new HtmlFile(outputFileName, type, zoom);
			htmlFile.convertPdfToHtml(pdfFileName);
			htmlFile.closeFile();
		} catch (Exception e) {
            System.err.println( "Filed to convert Pdf to Html." );
			e.printStackTrace();
		}
		System.out.println("Done");
	}
}
