/**
 * Copyright Alex Objelean
 */
package ro.isdc.wro.examples;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ro.isdc.wro.cache.CacheEntry;
import ro.isdc.wro.cache.ContentHashEntry;
import ro.isdc.wro.http.support.ServletContextAttributeHelper;
import ro.isdc.wro.manager.WroManager;
import ro.isdc.wro.manager.factory.InjectableWroManagerFactoryDecorator;
import ro.isdc.wro.manager.factory.WroManagerFactory;
import ro.isdc.wro.model.WroModel;
import ro.isdc.wro.model.resource.ResourceType;

/**
 * @author Alex Objelean
 */
@SuppressWarnings("serial")
public class ExternalResourceServlet extends HttpServlet {
  private static final Logger LOG = LoggerFactory.getLogger(ExternalResourceServlet.class);

  
  @Override
  protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
    throws ServletException, IOException {
    final ServletContextAttributeHelper helper = new ServletContextAttributeHelper(getServletContext());
    final WroManagerFactory managerFactory = helper.getManagerFactory();
    System.out.println("managerFactory: " + managerFactory);
    final WroManager wroManager = managerFactory.create();
    
    final CacheEntry cacheKey = new CacheEntry("login", ResourceType.CSS, false);
    ContentHashEntry cacheValue = wroManager.getCacheStrategy().get(cacheKey);
    LOG.info("cacheValue: {}", cacheValue);
    
    final WroModel model = wroManager.getModelFactory().create();
    LOG.debug("model: {}", model);
    resp.sendRedirect("http://code.jquery.com/jquery-1.4.4.js");
  }
}
