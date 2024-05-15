package cn.xrb.clouduser.common.converter;


import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BufferedImageHttpMessageConverter extends AbstractHttpMessageConverter<BufferedImage> {

    public BufferedImageHttpMessageConverter() {
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(MediaType.IMAGE_PNG);
        setSupportedMediaTypes(supportedMediaTypes);
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return BufferedImage.class.isAssignableFrom(clazz);
    }

    @Override
    protected BufferedImage readInternal(Class<? extends BufferedImage> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    protected void writeInternal(BufferedImage bufferedImage, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        ImageIO.write(bufferedImage, "png", outputMessage.getBody());
    }
}
