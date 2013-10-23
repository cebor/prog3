package de.fhro.inf.p3.uebung04;

import java.lang.reflect.Method;

/**
 * Created by felix on 10/23/13.
 *
 * XML
 */
public class GenerateXML  {
    public static String generateInterfaceDescriptionXML(Class<?> interfaze) {

        if (!interfaze.isInterface())
            throw new IllegalArgumentException();

        StringBuilder xml = new StringBuilder();

        String name = interfaze.getSimpleName();
        String pkg = interfaze.getPackage().getName();

        xml
                .append("<interface name=\"")
                .append(name)
                .append("\">\n")
                .append("\t<package name=\"")
                .append(pkg)
                .append("\">\n");

        if (interfaze.getMethods().length != 0) {
            xml.append("\t<methods>\n");

            for (Method method : interfaze.getMethods()) {
                xml
                        .append("\t\t<method name=\"")
                        .append(method.getName())
                        .append("\">\n")
                        .append("\t\t\t<result type=\"")
                        .append(method.getReturnType())
                        .append("\"/>\n");

                if (method.getParameterTypes().length != 0) {
                    xml.append("\t\t\t<parameters>\n");

                    for (Class type : method.getParameterTypes()) {
                        xml
                                .append("\t\t\t\t<parameter type=\"")
                                .append(type.getName())
                                .append("\"/>\n");
                    }

                    xml.append("\t\t\t</parameters>\n");
                }

                xml.append("\t\t</method>\n");
            }

            xml.append("\t</methods>\n");
        }

        xml.append("</interface>\n");

        return xml.toString();
    }
}

