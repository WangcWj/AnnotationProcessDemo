package cn.annotation.wang;

import com.google.auto.service.AutoService;

import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;

import cn.annotation.wang.annotationlib.MyAnnotion;

/**
 * Created by WANG on 2018/8/29.
 */
@AutoService(Processor.class)
public class AnnotationProcessor extends AbstractProcessor {

    private Messager messager;
    private Elements elementUtils;
    private Filer filer;


    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        messager = processingEnvironment.getMessager();
        elementUtils = processingEnvironment.getElementUtils();
        filer = processingEnvironment.getFiler();

    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        messager.printMessage(Diagnostic.Kind.NOTE,"日志开始---------------");

        Set<? extends Element> elementsAnnotatedWith = roundEnvironment.getElementsAnnotatedWith(MyAnnotion.class);




        for (Element element:elementsAnnotatedWith) {
            messager.printMessage(Diagnostic.Kind.NOTE,"Element---------------"+element);

            if(element.getKind() == ElementKind.CLASS){
                TypeElement typeElement = (TypeElement) element;
               /* PackageElement packageElement = elementUtils.getPackageOf(element);
                String packagePath = packageElement.getQualifiedName().toString();
                String className = typeElement.getSimpleName().toString();
                try {
                    JavaFileObject sourceFile = filer.createSourceFile(packagePath + "." + className + "_ViewBinding", typeElement);
                    Writer writer = sourceFile.openWriter();
                    writer.write("package  "+packagePath +";\n");
                    writer.write("import  "+packagePath+"."+className+";\n");
                    writer.write("public class "+className+"_ViewBinding"+"  { \n");
                    writer.write("\n");
                    writer.append("       public "+className +"  targe;\n");
                    writer.write("\n");
                    writer.append("}");
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }*/

            }
        }


        messager.printMessage(Diagnostic.Kind.NOTE,"日志结束---------------");
        return false;
    }


    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> supportedOptions = new HashSet<>();
        supportedOptions.add(MyAnnotion.class.getCanonicalName());
        return supportedOptions;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latest();
    }
}
