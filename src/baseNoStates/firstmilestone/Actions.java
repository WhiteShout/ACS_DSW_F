package baseNoStates.firstmilestone;

/**
 * Constantes con los nombres de las acciones del sistema de control de accesos.
 * Se usan como valores literales para evitar errores de tipado.
 */
public final class Actions {
  // Acciones que afectan a la seguridad (bloquear/desbloquear)
  public static final String LOCK = "lock";
  public static final String UNLOCK = "unlock";
  public static final String UNLOCK_SHORTLY = "unlock_shortly";

  // Acciones sobre la puerta cuando está desbloqueada
  public static final String OPEN = "open";
  public static final String CLOSE = "close";
}
