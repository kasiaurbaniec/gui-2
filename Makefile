# Makefile for coemas 2.4

JAVAC = javac
OPTIONS = -sourcepath . -d .
SOURCES = $(wildcard *.java)
EXECS = $(SOURCES:%.java=%.class)

all: $(EXECS)
%.class: %.java
	$(JAVAC) $(OPTIONS) $<
clean:
	rm *.class