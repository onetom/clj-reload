# Clojure namespace reloading lab

The Rich-comments in `main.repl` illustrate the problem with reloading a
namespace, which defines a multi-method (`def.multi/x` or `mm/x` for short,
in this case).

After changing the definition of `mm/x` to the uncommented one and reloading it,
when we evaluate its call from the `main.repl` namespace, with the correct
arguments, it will still invoke the previous definition of `mm/x`.

However, if we run `(main.repl/reload-mm #'mm/x)`, the new multi-method
definition should be invoked.
