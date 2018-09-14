# Note

## Denormalized vs Normalized Databases
Normalized databases are designed to minimize redundancy.

- Benefit: information is only stored once
- Drawback: many common queries will require expensive joins

Denormalized databases are designed to optimize read time.

### Convert Null to zero, different string
SQL

nvl(value, 0);
nvl(value, "Null String");
