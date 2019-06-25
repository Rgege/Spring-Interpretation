package demo.ex01.pyrmont;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/*
  HTTP Response = Status-Line
    *(( general-header | response-header | entity-header ) CRLF)
    CRLF
    [ message-body ]
    Status-Line = HTTP-Version SP Status-Code SP Reason-Phrase CRLF
*/

public class Response {
    private static final Logger LOGGER = LoggerFactory.getLogger(Response.class);
    private static final int BUFFER_SIZE = 1024;
    Request request;
    OutputStream output;

    public Response(OutputStream output) {
        this.output = output;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void sendStaticResource() throws IOException {
        String uri = request.getUri();
        File file = new File(HttpServer.WEB_ROOT, request.getUri());
        try (BufferedReader br = new BufferedReader(new FileReader(file));
             PrintWriter pw = new PrintWriter(output, true);) {
            String contentType="text/html; charset=utf-8";
            if (file.exists()) {//
                if (equalsAny(uri.substring(uri.lastIndexOf(".")+1),"gif","jpg","ico","png")){
                    contentType="image/jpeg";
                }
                    String line = "HTTP/1.1 200 OK\n" +
                            "Server: Microsoft-IIS/4.0\n" +
                            "Date: Mon,5 Jan 2004 13:13:12 GMT\n" +
                            "Content-Type: "+contentType+"\n" +
                            "Content-Length: " + file.length() +"\n"+
                            "Last-Modified: Mon,5 Jan 2004 13:13:12 GMT" +
                            "\r\n";
                pw.println(line);
                while ((line = br.readLine()) != null) {
                    pw.println(line);
                }

            } else {
                LOGGER.warn(String.format("Resource [%s] Not Found", request.getUri()));
                String errorMessage = "HTTP/1.1 404 File Not Found\r\n" +
                        "Content-Type: text/html\r\n" +
                        "Content-Length: 23\r\n" +
                        "\r\n" +
                        "<h1>File Not Found</h1>";
                pw.println(errorMessage);
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            send500(e);
        }
    }

    private void send500(Exception e) {
        try (PrintWriter pw = new PrintWriter(output, true);) {
            String errorMessage = "HTTP/1.1 500\r\n" +
                    "Content-Type: text/html\r\n" +
                    "Content-Length: " + e.getMessage().length()+"\r\n"+
                    "\r\n";
            pw.println(errorMessage);
            e.printStackTrace(pw);
        }
    }

    @Deprecated
    public void sendStaticResourceOld() throws IOException {
        byte[] bytes = new byte[BUFFER_SIZE];
        FileInputStream fis = null;
        try {
            File file = new File(HttpServer.WEB_ROOT, request.getUri());
            if (file.exists()) {
                fis = new FileInputStream(file);
                int ch = fis.read(bytes, 0, BUFFER_SIZE);
                while (ch != -1) {
                    output.write(bytes, 0, ch);
                    ch = fis.read(bytes, 0, BUFFER_SIZE);
                }
            } else {
                // file not found
                String errorMessage = "HTTP/1.1 404 File Not Found\r\n" +
                        "Content-Type: text/html\r\n" +
                        "Content-Length: 23\r\n" +
                        "\r\n" +
                        "<h1>File Not Found</h1>";
                output.write(errorMessage.getBytes());
            }
        } catch (Exception e) {
            // thrown if cannot instantiate a File object
            System.out.println(e.toString());
        } finally {
            if (fis != null)
                fis.close();
        }
    }

    private boolean equalsAny(String str, String... vals) {
        boolean b = false;

        if (null != str) {
            for (String val : vals) {
                if (val != null && str.toUpperCase().equals(val.toUpperCase())) {
                    b = true;
                    break;
                }
            }
        }
        return b;
    }
}