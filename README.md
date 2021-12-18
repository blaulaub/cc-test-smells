# Clean Coders: Test Smells

This project illustrates a few examples of test smells. 'Test smell' is a metaphor
describing the moment when you see some test code and immediately feel: There will be
problems. 

This project tries to be multilingual, but at the same time, the examples are centered
on OO. The original examples stem from old Java before the introduction of generics, but
have been translated for Java 11, C# 9 resp. .NET 5, and maybe others...

(At the time of writing, Java 17 and C# 10 resp. .NET 6 have been published, but we are
a bit conservative here.)

## Structure

On the top level of this project, choose your language.

Per language, there are usually two artefacts (binaries) resp. sub-projects: One
containing the test code (the code executing the test), and one containing some
"backing code" (the code under test).

The original material only supplied the test methods, written in Java 1.4 or earlier.
To make that work, the so-called "backing code" has been re-invented out of thin air,
as well as some test helpers.

Look at the READMEs per language for further instructions or details.
