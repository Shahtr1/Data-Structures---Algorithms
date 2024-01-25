function addTo80(n) {
  //   console.log("long time");
  return n + 80;
}

function memoizedAddTo80() {
  let cache = {}; // Closures
  return (n) => {
    if (n in cache) {
      console.log("cache hit!");
    } else {
      console.log("cache miss");
      cache[n] = n + 80;
    }

    return cache[n];
  };
}

const memoized = memoizedAddTo80();

// will take long time
addTo80(5);
addTo80(5);
addTo80(5);

// will be fast, its simple property access, superfast with hash table
memoized(5);
memoized(5);
memoized(5);
