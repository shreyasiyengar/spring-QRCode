package SpringQRAPP.controller;

import SpringQRAPP.model.QRCodeGenerator;
import com.google.zxing.WriterException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class QRController {

    private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/QRCode.png";

    @GetMapping(value = "/genrateAndDownloadQRCode/{codeText}/{width}/{height}")
    public void download(@PathVariable("codeText")String codeText,@PathVariable("width")Integer width,@PathVariable("height")Integer height) throws IOException, WriterException {
        QRCodeGenerator.generatedQRCodeImage(codeText,width,height,QR_CODE_IMAGE_PATH);
    }

    @GetMapping(value = "/genrateQRCode/{codeText}/{width}/{height}")
    public ResponseEntity<byte[]> generatedQRCode(@PathVariable("codeText")String codeText,@PathVariable("width")Integer width,@PathVariable("height")Integer height) throws IOException, WriterException {
        return ResponseEntity.status(HttpStatus.OK).body(QRCodeGenerator.getQRCodeImage(codeText,width,height));
    }
}
