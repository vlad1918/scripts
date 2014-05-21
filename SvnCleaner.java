package tools;

import java.io.File;

/**
 * Class that cleans all dirt before a SVN commit with MARA
 * @author vlad.dima
 *
 */
public class SvnCleaner {

	private String COMA_WEB 	= "..\\CoMa\\coma.web";
	private String COMA_WEB_WAR = COMA_WEB+"\\war\\coma.web"; 
	private String COMA_TOOLBAR = COMA_WEB_WAR+"\\images\\tool-bar-button-icons"; 
	private String COMA_CSS 	= COMA_WEB_WAR+"\\css"; 
	private String COMA_MANIFEST= COMA_WEB+"\\war\\WEB-INF\\deploy\\coma.web\\rpcPolicyManifest\\manifests";
	
	private void clean() {
		
		int counter = 0;
		
		//Delete generated PDFs
		File comaWeb = new File(COMA_WEB);
		for (File file : comaWeb.listFiles()) {
			if (file.getName().startsWith("output-") && file.getName().endsWith(".pdf")){			
				file.delete();
				counter++;
			}
		}

		//Delete from war/coma.web
		File comaWebWar = new File(COMA_WEB_WAR);
		for (File file : comaWebWar.listFiles()) {
			if (file.getName().endsWith(".gwt.rpc") || file.getName().endsWith(".cache.png")){			
				file.delete();
				counter++;
			}
		}
		
		//Delete from images/tool-bar-button-icons
		File toolbar = new File(COMA_TOOLBAR);
		for (File file : toolbar.listFiles()) {
			if (! file.getName().equals("record-next.gif")){			
				file.delete();
				counter++;
			}
		}
		
		//Delete from css
		File css = new File(COMA_CSS);
		for (File file : css.listFiles()) {
			if (file.getName().equals("mmscommon.css")){			
				file.delete();
				counter++;
			}
		}
		
		//Delete from manifest
		File manif = new File(COMA_MANIFEST);
		for (File file : manif.listFiles()) {			
				file.delete();
				counter++;
		}
		
		System.out.println(counter+" files successfully removed");
	}
	
	public static void main(String[] args) {
		SvnCleaner sc = new SvnCleaner();
		sc.clean();
	}	
}
