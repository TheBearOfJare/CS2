import javax.swing.*;
/**
 * Set of utility methods for handeling threading relating to the event thread and scheduling.
 * Allows the differed or immediate execution of runnables and monitoring their execution.
 * 
 * @author Dcn. TenBroek
 * @author Jared Gleisner (Documentation)
 *
 */
public class EventThreadUtil {

	/**
	 * Used to find the thread class that these utilities are running in.
	 * @author Dcn. TenBroek
	 * @author Jared Gleisner (Documentation)
	 */
	protected static Class EVENT_DISPATCH_THREAD_CLASS;

	static {
		try {
			EVENT_DISPATCH_THREAD_CLASS = Class.forName("java.awt.EventDispatchThread");
		} catch(Exception e) {
			e.printStackTrace(System.err);
		}
	}

	/**
	* Determines whether or not the current thread is an instance of the event thread.
	* This method does not require arguments.
	* @author Dcn. TenBroek
	* @author Jared Gleisner (Documentation)
	*
	* @return	   whether or not the current thread is on the event thread 
	* @see         Thread
	*/
	public static final boolean isCurrentThreadEventThread() {
		return EVENT_DISPATCH_THREAD_CLASS.isInstance(Thread.currentThread());
	}

	/**
	* Runs the supplied Runnable method in the Event Thread immediately.
	* This method requires a valid Runnable.
	*
	* @author Dcn. TenBroek
	* @author Jared Gleisner (Documentation)
	*
	* @param  runnable the supplied runnable method
	* @see         Runnable
	* @see         SwingUtilities
	*/
	public static final void runNowInEventThread(Runnable runnable) {
		if(runnable == null) {
			return;
		}
		if(isCurrentThreadEventThread()) {
			runnable.run();
		} else {
			try {
				SwingUtilities.invokeAndWait(runnable);
			} catch(InterruptedException ie) {
			} catch(java.lang.reflect.InvocationTargetException ite) {}
		}
	}

	/**
	* Runs the supplied Runnable method in the Event Thread eventually (deferred).
	* This method requires a valid Runnable.
	*
	* @author Dcn. TenBroek
	* @author Jared Gleisner (Documentation)
	*
	* @param runnable the supplied runnable method
	* @see         Runnable
	* @see         SwingUtilities
	*/
	public static final void runLaterInEventThread(Runnable runnable) {
		if(runnable == null) {
			return;
		}
		if(isCurrentThreadEventThread()) {
			runnable.run();
		} else {
			SwingUtilities.invokeLater(runnable);
		}
	}
}